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
                    <form role="form" method="post" action="/sell/user/save">
                        <div class="form-group">
                            <label>用户名</label>
                            <input name="username" type="text" class="form-control" value="${(userInfoDTO.username)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>密码</label>
                            <input name="password" type="password" class="form-control" value="${(userInfoDTO.password)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>手机</label>
                            <input name="userPhone" type="number" class="form-control" value="${(userInfoDTO.userPhone)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>账户类型</label>
                            <input name="accountType" type="text" disabled="disabled" class="form-control" value="${(userInfoDTO.accountType)!''}"/>
                        </div>
                        <input hidden type="text" name="userId" value="${(userInfoDTO.userId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>