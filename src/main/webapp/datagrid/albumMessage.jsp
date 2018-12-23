<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">
    var row = $("#albumTreeGrid").treegrid("getSelected");
    $(function(){
        $("#name1").append(row.title);
        $("#count1").append(row.count);
        $("#score1").append(row.score);
        $("#author1").append(row.author);
        $("#broadcast1").append(row.broadcast);
        $("#brief1").append(row.brief);
        $("#pubDate1").append(row.pubDate);
        $("#coverImg1").append("<img src='${pageContext.request.contextPath}/img/audioCollection/"+row.coverImg+"'/>");
    })
</script>
<table border="1">
    <tr>  <td>名字</td>  <td id="name1"></td>  </tr>
    <tr>  <td>章节数</td>  <td id="count1"></td>  </tr>
    <tr>  <td>评分</td>  <td id="score1"></td>  </tr>
    <tr>  <td>作者</td>  <td id="author1"></td>  </tr>
    <tr>  <td>播音</td>  <td id="broadcast1"></td>  </tr>
    <tr>  <td>简介</td>  <td id="brief1"></td>  </tr>
    <tr>  <td>发布日期</td>  <td id="pubDate1"></td>  </tr>
    <tr>  <td>专辑图片</td>  <td id="coverImg1"></td>  </tr>
</table>


