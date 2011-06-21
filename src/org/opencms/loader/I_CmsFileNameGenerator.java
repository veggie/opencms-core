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

package org.opencms.loader;

import org.opencms.file.CmsObject;
import org.opencms.file.CmsResource;
import org.opencms.main.CmsException;
import org.opencms.util.PrintfFormat;
import org.opencms.xml.content.CmsXmlContent;
import org.opencms.xml.types.I_CmsXmlContentValue;

import java.util.Iterator;

/**
 * Provides methods to generate file names either for the <code>urlName</code> mapping 
 * or when using a "new" operation in the context of the direct edit interface.<p>
 * 
 * @since 8.0.0
 */
public interface I_CmsFileNameGenerator {

    /** The "number" macro. */
    public static final String MACRO_NUMBER = "number";

    /** Format for file create parameter. */
    public static final PrintfFormat NUMBER_FORMAT = new PrintfFormat("%0.5d");

    /**
     * Generates a new file name based on the provided OpenCms user context and name pattern.<p>
     * 
     * Used by the collector API as well as the galleries introduced with OpenCms 8 (ADE).
     * 
     * @param cms the current OpenCms user context
     * @param namePattern the pattern to be used when generating the new resource name
     * @param defaultDigits the default number of digits to use for numbering the created file names 
     * 
     * @return a new resource name based on the provided OpenCms user context and name pattern
     * 
     * @throws CmsException in case something goes wrong
     */
    public abstract String getNewFileName(CmsObject cms, String namePattern, int defaultDigits) throws CmsException;

    /**
     * Returns a sequence of URL name candidates for the given XML content value as an iterator.<p>
     * 
     * This is used by the <code>urlName</code> mapping of XML contents which enable SEO friendly URLs 
     * automatically generated for example from the resource title.<p>
     * 
     * Usually the first URL name from this sequence which does not already exist for a different 
     * resource will be used for the URL name mapping.<p>
     * 
     * @param cms the CMS context 
     * @param content the XML content 
     * @param value the content value from which the URL name should be generated 
     * @param sibling the sibling to which the URL name should be mapped 
     * 
     * @return the sequence of URL name candidates
     *  
     * @throws CmsException if something goes wrong 
     */
    Iterator<String> getUrlNameSequence(
        CmsObject cms,
        CmsXmlContent content,
        I_CmsXmlContentValue value,
        CmsResource sibling) throws CmsException;
}