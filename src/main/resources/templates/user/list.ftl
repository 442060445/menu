<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

<#--边栏sidebar-->
<#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>用户ID</th>
                            <th>用户名</th>
                            <th>手机</th>
                            <th>openid</th>
                            <th>帐号状态</th>
                            <th>帐号类型</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <#list userInfoDTOPage.content as userInfo>
                        <tr>
                            <td>${userInfo.userId}</td>
                            <td>${userInfo.username}</td>
                            <td>${userInfo.userPhone}</td>
                            <td>${userInfo.openid}</td>
                            <td>${userInfo.accountStatus}</td>
                            <td>${userInfo.accountType}</td>
                            <td>${userInfo.createTime}</td>
                            <td>${userInfo.updateTime}</td>
                            <td><a href="/sell/user/index?userId=${userInfo.userId}">修改</a></td>
                            <td>
                                <#if userInfo.getAccountStatusEnum().message == "停用">
                                    <a href="/sell/user/enable?userId=${userInfo.userId}">激活</a>
                                <#else>
                                    <a href="/sell/user/disable?userId=${userInfo.userId}">停用</a>
                                </#if>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>

            <#--分页-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/sell/user/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <#list 1..userInfoDTOPage.getTotalPages() as index>
                        <#if currentPage == index>
                            <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/sell/user/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>

                    <#if currentPage gte userInfoDTOPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/sell/user/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>