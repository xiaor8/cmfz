<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
    $(function(){
        $("#commitBtn1").click(function(){
            $('#insertBannerForm').form('submit', {
                url: "${pageContext.request.contextPath}/banner/insertOne",
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


<form id="insertBannerForm" method="post" enctype="multipart/form-data">
    <div>
        <label >文件名:</label>
        <input class="easyui-validatebox" type="text" name="title" data-options="required:true" />
    </div>
    <div>
        <label >描&nbsp;述:</label>
        <input class="easyui-validatebox" type="text" name="description" data-options="required:true" />
    </div>

    <div>
        <label >文件:</label>
        <input class="easyui-filebox" name="file1" data-options="prompt:'Choose a file...'" >
    </div>

    <a id="commitBtn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">上传</a>
    <a id="cancelBtn1" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-undo'">取消</a>
</form>