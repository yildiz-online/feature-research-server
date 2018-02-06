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
package be.yildizgames.engine.feature.research.generated.database.tables;


import be.yildizgames.engine.feature.research.generated.database.Indexes;
import be.yildizgames.engine.feature.research.generated.database.Keys;
import be.yildizgames.engine.feature.research.generated.database.Public;
import be.yildizgames.engine.feature.research.generated.database.tables.records.ResearchesRecord;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Researches extends TableImpl<ResearchesRecord> {

    private static final long serialVersionUID = 2039650949;

    /**
     * The reference instance of <code>PUBLIC.RESEARCHES</code>
     */
    public static final Researches RESEARCHES = new Researches();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ResearchesRecord> getRecordType() {
        return ResearchesRecord.class;
    }

    /**
     * The column <code>PUBLIC.RESEARCHES.RES_ID</code>.
     */
    public final TableField<ResearchesRecord, Short> RES_ID = createField("RES_ID", org.jooq.impl.SQLDataType.SMALLINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.RESEARCHES.PLY_ID</code>.
     */
    public final TableField<ResearchesRecord, Short> PLY_ID = createField("PLY_ID", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>PUBLIC.RESEARCHES.NAME</code>.
     */
    public final TableField<ResearchesRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>PUBLIC.RESEARCHES</code> table reference
     */
    public Researches() {
        this(DSL.name("RESEARCHES"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.RESEARCHES</code> table reference
     */
    public Researches(String alias) {
        this(DSL.name(alias), RESEARCHES);
    }

    /**
     * Create an aliased <code>PUBLIC.RESEARCHES</code> table reference
     */
    public Researches(Name alias) {
        this(alias, RESEARCHES);
    }

    private Researches(Name alias, Table<ResearchesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Researches(Name alias, Table<ResearchesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_9);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ResearchesRecord, Short> getIdentity() {
        return Keys.IDENTITY_RESEARCHES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ResearchesRecord> getPrimaryKey() {
        return Keys.PK_RESEARCHES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ResearchesRecord>> getKeys() {
        return Arrays.<UniqueKey<ResearchesRecord>>asList(Keys.PK_RESEARCHES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Researches as(String alias) {
        return new Researches(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Researches as(Name alias) {
        return new Researches(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Researches rename(String name) {
        return new Researches(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Researches rename(Name name) {
        return new Researches(name, null);
    }
}
