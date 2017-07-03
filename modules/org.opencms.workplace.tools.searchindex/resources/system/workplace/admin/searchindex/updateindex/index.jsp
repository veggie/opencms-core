<%@ page import="
	org.opencms.main.*, 
	org.opencms.search.*, 
	org.opencms.jsp.*,
	org.opencms.workplace.*,
	org.opencms.workplace.tools.content.*,
	java.util.*
"%><%

    // initialize the workplace class
    CmsDialog wp = new CmsPropertyChange(pageContext, request, response);

    // Create a JSP action element
    CmsJspActionElement cms = wp.getJsp();
    
    // Get the search manager
    CmsSearchManager searchManager = OpenCms.getSearchManager(); 
%>

<%= wp.htmlStart(null) %>
<%= wp.bodyStart("dialog") %>

<%= wp.dialogStart() %>
<%= wp.dialogContentStart(wp.key("icon.updateindex")) %>
	
		
	<table width='400'>
		<tr><th>Name</th><th>Rebuild Mode</th><th>Project</th><th>Locale</th></tr>
<%
    List indexNames = searchManager.getIndexNames();
	for (int i = 0, n = indexNames.size(); i < n; i++) {
		String indexName = (String)indexNames.get(i);
		CmsSearchIndex index = searchManager.getIndex(indexName);
%>
		<tr>
			<td><%=index.getName()%></td>
			<td><%=index.getRebuildMode()%></td>
			<td><%=index.getProject()%></td>
			<td><%=index.getLocale()%></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="4">
<%
	
		List sourceNames = index.getSourceNames();
		for (int j = 0, m = sourceNames.size(); j < m; j++) {
			String sourceName = (String)sourceNames.get(j);
			CmsSearchIndexSource indexSource = searchManager.getIndexSource(sourceName);
			
			List resourceNames = indexSource.getResourcesNames();
			for (int k = 0, l = resourceNames.size(); k < l; k++) {
				String resourceName = (String)resourceNames.get(k);
				out.println(resourceName);
				
				if (k < (l-1)) {
					out.println("<br>");
				}
			}
		}
	}
%>
			</td>
		</tr>
	</table>				
</p>

<p>

	<form method="post" action='<%=cms.link("/system/workplace/admin/searchindex/updateindex/rebuild.jsp") + "?style=" + wp.getParamStyle() %>'>
    	<input type="submit" value="Rebuild All">
	</form>

<%= wp.dialogContentEnd() %>
<%= wp.dialogEnd() %>
<%= wp.bodyEnd() %>
<%= wp.htmlEnd() %>
