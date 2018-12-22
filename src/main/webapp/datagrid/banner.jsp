<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function(){
        $("#bannerAddPanel").dialog({
            title:"添加轮播图",
            href:"${pageContext.request.contextPath}/datagrid/insertBanner.jsp",
            width:500,
            height:150,
            closed:true
        });


        $("#bannerDatagrid").edatagrid({
            updateUrl: "${pageContext.request.contextPath}/banner/updateOne",
            destroyUrl: "${pageContext.request.contextPath}/banner/deleteOne",
            fitColumns:true,
            fit:true,
            pagination:true,
            pageSize:3,
            pageList:[3,6,9,10],
            toolbar: [{
                iconCls: 'icon-add',
                text: "添加",
                handler: function(){
                    $("#bannerAddPanel").dialog("open")
                }
            },'-',{
                iconCls: 'icon-edit',
                text: "修改",
                handler: function(){
                    var row = $("#bannerDatagrid").edatagrid("getSelected");
                    if(row==null){
                        alert("请选中一行");
                    }else{
                        var index = $("#bannerDatagrid").edatagrid("getRowIndex",row);
                        console.log(index);
                        $("#bannerDatagrid").edatagrid("editRow", index);
                    }
                }
            },'-',{
                iconCls: 'icon-remove',
                text: "删除",
                handler: function(){
                    var row = $("#bannerDatagrid").edatagrid("getSelected");
                    if(row==null){
                        alert("请选中一行");
                    }else{
                        var index = $("#bannerDatagrid").edatagrid("getRowIndex",row);
                        console.log(index);
                        $("#bannerDatagrid").edatagrid("destroyRow", index);
                    }
                }
            },'-',{
                iconCls: 'icon-save',
                text: "保存",
                handler: function(){
                    var index = $("#bannerDatagrid").edatagrid("saveRow");
                }
            }],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>description: ' + rowData.description + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }


        });
    })
</script>

<table class="easyui-datagrid" style="width:400px;height:250px" id="bannerDatagrid"
       data-options="url:'${pageContext.request.contextPath}/banner/queryAll',fitColumns:true,singleSelect:true">
    <thead>
    <tr>
        <th data-options="field:'title',width:100">图片名</th>
        <th data-options="field:'status',width:100,
        editor: {
                       type: 'text',
                  options: {required:true}
        }">状态</th>
        <th data-options="field:'pubDate',width:100,align:'right'">时间</th>
    </tr>
    </thead>
</table>

<div id="bannerAddPanel"></div>


