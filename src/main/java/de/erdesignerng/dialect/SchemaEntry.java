/**
 * Mogwai ERDesigner. Copyright (C) 2002 The Mogwai Project.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 59 Temple
 * Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package de.erdesignerng.dialect;

public class SchemaEntry {

    private String catalogName;

    private String schemaName;

    public SchemaEntry(String aCatalogName, String aSchemaName) {
        catalogName = aCatalogName;
        schemaName = aSchemaName;
    }

    /**
     * Gibt den Wert des Attributs <code>catalogName</code> zur�ck.
     * 
     * @return Wert des Attributs catalogName.
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * Setzt den Wert des Attributs <code>catalogName</code>.
     * 
     * @param catalogName
     *            Wert f�r das Attribut catalogName.
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    /**
     * Gibt den Wert des Attributs <code>schemaName</code> zur�ck.
     * 
     * @return Wert des Attributs schemaName.
     */
    public String getSchemaName() {
        return schemaName;
    }

    /**
     * Setzt den Wert des Attributs <code>schemaName</code>.
     * 
     * @param schemaName
     *            Wert f�r das Attribut schemaName.
     */
    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public String toString() {
        if (catalogName != null) {
            return schemaName + "@" + catalogName;
        }
        return schemaName;
    }
}
