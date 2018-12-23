<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    $(function(){
        $("#albumAddPanel").dialog({
            title:"添加专辑",
            href:"${pageContext.request.contextPath}/datagrid/insertAlbum.jsp",
            width:500,
            height:300,
            closed:true
        });
        $('#albumTreeGrid').treegrid({
            url:"${pageContext.request.contextPath}/album/queryAll",
            idField:'id',
            treeField:'title',
            columns:[[
                {field:'title',title:'名字',width:100},
                {field:'url',title:'下载路径',width:100},
                {field:'size',title:'章节大小',width:100},
                {field:'duration',title:'章节时长'}
            ]],
            fitColumns:true,
            fit:true,
            pagination:true,
            pageSize:3,
            pageList:[3,6,9,10],
            toolbar: [{
                iconCls: 'icon-add',
                text: "专辑详情",
                handler: function(){
                    var row = $("#albumTreeGrid").treegrid("getSelected");
                    console.log(row);
                    if(row.author==null){
                        alert("请选中一个专辑");
                    }else{
                        $('#albumMessagePropertyGrid').dialog({
                            title: 'My Dialog',
                            width: 400,
                            height: 200,
                            closed: false,
                            cache: false,
                            href: "${pageContext.request.contextPath}/datagrid/albumMessage.jsp",
                            modal: true,
                            closed: false
                        });
                    }
                }
            },'-',{
                iconCls: 'icon-edit',
                text: "添加专辑",
                handler: function(){
                    $("#albumAddPanel").dialog("open");
                }
            },'-',{
                iconCls: 'icon-remove',
                text: "添加章节",
                handler: function(){
                    alert("添加章节");
                }
            },'-',{
                iconCls: 'icon-save',
                text: "下载音频",
                handler: function(){
                    alert("下载音频");
                }
            }],

        });
    })
</script>

<table id="albumTreeGrid"></table>

<div id="albumMessagePropertyGrid" style="width:300px"></div>

<div id="albumAddPanel"></div>



