/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.engine.feature.research.server.persistence;

import be.yildizgames.common.model.PlayerId;
import be.yildizgames.common.util.StringUtil;
import be.yildizgames.engine.feature.research.ResearchId;
import be.yildizgames.engine.feature.research.ResearchManager;
import be.yildizgames.engine.feature.research.server.PlayerResearch;
import be.yildizgames.engine.feature.research.server.generated.database.tables.Researches;
import be.yildizgames.engine.feature.research.server.generated.database.tables.records.ResearchesRecord;
import be.yildizgames.module.database.data.SimplePersistentData;
import org.jooq.DSLContext;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.Optional;

/**
 * Persistent data for researches.
 *
 * @author Grégory Van den Borre
 */
public final class PersistentResearch implements SimplePersistentData<PlayerResearch> {

    /**
     * Database table containing the data.
     */
    private static final Researches table = Researches.RESEARCHES;

    /**
     * Full constructor.
     *
     * @param c       SQL connection.
     * @param researchManager Research manager.
     */
    public PersistentResearch(Connection c, final ResearchManager researchManager) {
        super();
        try (DSLContext create = this.getDSL(c)) {
            Optional
                    .ofNullable(create.selectFrom(table).fetch())
                    .ifPresent(data -> data.forEach(r -> {
                            PlayerId player = PlayerId.valueOf(r.getPlyId().intValue());
                            if (!r.getName().isEmpty()) {
                                String[] researches = r.getName().split(",");
                                for (String s : researches) {
                                    researchManager.addResearch(ResearchId.valueOf(Integer.valueOf(s)), player);
                                }
                            }
                        }));
        }
    }

    @Override
    public PlayerResearch save(final PlayerResearch data, Connection c) {
        this.creteOrUpdateEntry(data, c);
        return data;
    }

    @Override
    public void update(PlayerResearch data, Connection c) {
        this.creteOrUpdateEntry(data, c);
    }

    private void creteOrUpdateEntry(PlayerResearch data, Connection c) {
        try (DSLContext create = this.getDSL(c)) {
            ResearchesRecord research = create.fetchOne(table, table.PLY_ID.equal((short)data.getPlayerId().value));
            if(research == null) {
                research = create.newRecord(table);
                research.setPlyId((short) data.getPlayerId().value);
            }
            research.setName(StringUtil.toString(data.getResearches()));
            research.store();
        }
    }

    private DSLContext getDSL(Connection c) {
        Settings settings = new Settings();
        settings.setExecuteLogging(false);
        return DSL.using(c, settings);
    }
}
