/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.gwt.client;

import org.opencms.util.CmsUUID;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Javascript overlay object holding data needed to edit a content collector list element.<p>
 * 
 * @since 8.0.0
 */
public final class CmsEditableDataJSO extends JavaScriptObject implements I_CmsEditableData {

    /**
     * Constructor.<p>
     */
    protected CmsEditableDataJSO() {

        // nothing to do
    }

    /**
     * Parses the given JSON text and returns the editable data object.<p>
     * 
     * @param jsonText the JSON text to parse
     * 
     * @return the data object
     */
    public static native CmsEditableDataJSO parseEditableData(String jsonText) /*-{
        return eval('(' + jsonText + ')');
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getEditId()
     */
    public native String getEditId() /*-{
        return this.editId ? this.editId : "";
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getElementLanguage()
     */
    public native String getElementLanguage() /*-{
        return this.elementlanguage ? this.elementlanguage : "";
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getElementName()
     */
    public native String getElementName() /*-{
        return this.elementname ? this.elementname : "";
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getNewLink()
     */
    public native String getNewLink() /*-{
        return this.newlink ? this.newlink : "";
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getNewTitle()
     */
    public native String getNewTitle() /*-{
        return this.newtitle ? this.newtitle : "";
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getNoEditReason()
     */
    public native String getNoEditReason() /*-{

        if (this.noEditReason)
            return this.noEditReason;
        else
            return null;
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getSitePath()
     */
    public native String getSitePath() /*-{
        return this.sitePath ? this.sitePath : "";
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#getStructureId()
     */
    public CmsUUID getStructureId() {

        return new CmsUUID(nativeGetStructureId());
    }

    /**
     * Returns if the delete button should be present.<p>
     * 
     * @return <code>true</code> if the delete button should be present
     */
    public native boolean hasDelete() /*-{
        return this.hasDelete;
    }-*/;

    /**
     * Returns if the edit button should be present.<p>
     * 
     * @return <code>true</code> if the edit button should be present
     */
    public native boolean hasEdit() /*-{
        return this.hasEdit;
    }-*/;

    /**
     * Returns if the new button should be present.<p>
     * 
     * @return <code>true</code> if the new button should be present
     */
    public native boolean hasNew() /*-{
        return this.hasNew;
    }-*/;

    /**
     * @see org.opencms.gwt.client.I_CmsEditableData#setSitePath(java.lang.String)
     */
    public native void setSitePath(String sitePath) /*-{

        this.sitePath = sitePath;
    }-*/;

    /**
     * Returns the structure id as string.<p>
     * 
     * @return the structure id as string
     */
    private native String nativeGetStructureId() /*-{
        return this.structureId ? this.structureId : "";
    }-*/;

}
