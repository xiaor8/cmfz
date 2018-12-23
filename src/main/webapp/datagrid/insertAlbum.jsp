<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
    $(function(){
        $("#commitAlbumFormBtn").click(function(){
            $('#insertAlbumForm').form('submit', {
                url: "${pageContext.request.contextPath}/album/insertOne",
                onSubmit: function(){
                    var isValid = $(this).form('validate');
                    return isValid;	// 返回false终止表单提交
                },
                success: function(){
                    $("#bannerAddPanel").dialog("close");
                    $.messager.show({
                        title:'提示',
                        msg:'添加成功',
                        timeout:5000,
                        showType:'slide'
                    });

                }
            });

        })
    })
</script>


<form id="insertAlbumForm" method="post" enctype="multipart/form-data">
    <div>
        <label >专辑名称:</label>
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true" />
    </div>
    <div>
        <label >作&nbsp;&nbsp;者:</label>
        <input class="easyui-validatebox" type="text" name="author" data-options="required:true" />
    </div>
    <div>
        <label >播&nbsp;&nbsp;音:</label>
        <input class="easyui-validatebox" type="text" name="broadcast" data-options="required:true" />
    </div>
    <div>
        <label >简&nbsp;&nbsp;介:</label>
        <input class="easyui-validatebox" type="text" name="brief" data-options="required:true" />
    </div>
    <div>
        <label >出版时间:</label>
        <input class="easyui-datebox" name="file1" data-options="prompt:'Choose a file...'" >
    </div>
    <div>
        <label >封面图片:</label>
        <input class="easyui-filebox" name="file1" data-options="prompt:'Choose a file...'" >
    </div>

    <a id="commitAlbumFormBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">上传</a>
    <a id="cancelAlbumFormBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">取消</a>
</form>