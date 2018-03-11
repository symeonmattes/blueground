<%@page import="Wunderground.apiWunderground"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wunderground Table</title>
        <style>
            table{border-collapse:colapse;border-spacing:0;}
            th{background:#417ca4;border:1px solid #000;width:50%;}
            td{border:1px dotted #000;padding:5px;width:50%;}
            tbody tr.row1 td{border-top:none;}
            thead tr.row1 th{border-bottom:none;}
            thead tr.row2 th:first-child{border-right:none;}
            
        </style>        
    </head>
    <body>
        
        <%
            apiWunderground aw = new apiWunderground();
            aw.setJSONWunderground();
            
        %>
        
        <table>
            <thead>
                <tr class="row1">
                    <th colspan="2">Table 2</th>
                </tr>
                <tr class="row2">
                    <th>Metric</th>
                    <th>Keyword</th>
                </tr>
            </thead>
            <tbody>
                <tr class="row1">
                    <td>Max percentage humidity</td>
                    <td><% out.print(aw.getMaxPercentageHumidity()); %></td>
                </tr>
                <tr>
                    <td>Max Temp in C</td>
                    <td><% out.print(aw.getMaxTempInCelcium()); %></td>
                </tr>
                <tr>
                    <td>Min Temp in C</td>
                    <td><% out.print(aw.getMinTempInCelcium()); %></td>
                </tr> 
                <tr>
                    <td>Precipitation in mm</td>
                    <td><% out.print(aw.getPrecipitationInMM()); %></td>
                </tr>                  
            </tbody>
        </table>
    </body>
</html>
