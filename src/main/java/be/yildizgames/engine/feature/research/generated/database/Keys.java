/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
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

/*
 * This file is generated by jOOQ.
*/
package be.yildizgames.engine.feature.research.generated.database;


import be.yildizgames.engine.feature.research.generated.database.tables.Players;
import be.yildizgames.engine.feature.research.generated.database.tables.Researches;
import be.yildizgames.engine.feature.research.generated.database.tables.records.PlayersRecord;
import be.yildizgames.engine.feature.research.generated.database.tables.records.ResearchesRecord;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import javax.annotation.Generated;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<PlayersRecord, Short> IDENTITY_PLAYERS = Identities0.IDENTITY_PLAYERS;
    public static final Identity<ResearchesRecord, Short> IDENTITY_RESEARCHES = Identities0.IDENTITY_RESEARCHES;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<PlayersRecord> PK_PLAYERS = UniqueKeys0.PK_PLAYERS;
    public static final UniqueKey<ResearchesRecord> PK_RESEARCHES = UniqueKeys0.PK_RESEARCHES;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<PlayersRecord, Short> IDENTITY_PLAYERS = createIdentity(Players.PLAYERS, Players.PLAYERS.PLY_ID);
        public static Identity<ResearchesRecord, Short> IDENTITY_RESEARCHES = createIdentity(Researches.RESEARCHES, Researches.RESEARCHES.RES_ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<PlayersRecord> PK_PLAYERS = createUniqueKey(Players.PLAYERS, "PK_PLAYERS", Players.PLAYERS.PLY_ID);
        public static final UniqueKey<ResearchesRecord> PK_RESEARCHES = createUniqueKey(Researches.RESEARCHES, "PK_RESEARCHES", Researches.RESEARCHES.RES_ID);
    }
}
