<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugin/js/backspace.js"></script>
<!--  <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugin/js/pwChk.js"></script>-->

<%@ include file="/resources/plugin/plugin.jsp" %>

  <style>
    .bg {
      background-image: url('https://cdn.dak.gg/maple/images/bg/layout-top-bg.jpg');
      background-size: cover;
      background-position: center;
      min-height: 520px;
    }
  </style>
<html>
<head>
    <title>Maple Time</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>

</head>
<!--  <body class="bg-primary">-->
<body class = "bg-secondary">
<div id="layoutAuthentication">
    <div id="layoutAuthentication_content">
        <main>
        <div class = bg>
            <div class="container">
                <div class="row justify-content-center">                
                    <div class="col-lg-5">
                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                            <div class="card-header"><h3 class="text-center font-weight-light my-4">Maple Time</h3></div>
                            <div class="card-body">
                                <form name="homeForm" accept-charset="utf-8" action="${pageContext.request.contextPath}/getocid"
                                      method="get">
                                    <div class="form-group">
                                        <label class="small mb-1" for="NickName">닉네임</label>
                                        <input class="form-control py-4" id="NickName" name="NickName" type="text"
                                               placeholder="닉네임을 입력하세요."/>
                                    </div>
                                    <div class="form-group">
                    					<span class="font-weight-bold text-white bg-dark"
                                              id="LoginCheck"></span>
                                    </div>
                                    <div class="row">
                                        <div class="col-8">

                                        </div>
                                        <!-- /.col -->
                                        <div class="col-8">
                                            <button id="loginBtn" type="submit" class="btn btn-primary">검색</button>
                                        </div>
                                        <!-- /.col -->
                                    </div>
                                </form>
                            </div>

                            <div class="card-footer text-center">
                                <div class="small"><a href="${pageContext.request.contextPath}/user/register">개발자에게 커피사주기
                                    후원!</a></div>
                            </div>
                            </div>
                            <!--  <div class="row">-->
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
	            <div class="row">
					<div class="col-xl-2 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">이번 주 무릉도장 1위</div>
								<div class="card-footer">
									<a class="small text-white stretched-link">${dojang1st_world_name} ${dojang1st_character_name} ${dojang1st_character_leve} ${dojang1st_character_class}</a>
								</div>
								<div class="card-footer d-flex align-items-center justify-content-between">
									<img src = ${dojang1st_character_image}></img>
								</div>
								<div class="card-footer d-flex align-items-center justify-content-between">
									${dojang1st_dojang_floor}층
								</div>
								<div class="card-footer d-flex align-items-center justify-content-between">
									${dojang1st_time_m}분 ${dojang1st_time_s}초
								</div>
									<!--  <div class="small text-white"><i class="fas fa-angle-right"></i>${dojang1st_character_name}</div>-->
								
						</div>
					</div>
					<div class="col-xl-2 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">이번 주 더 시드 1위</div>
								<div class="card-footer">
									<a class="small text-white stretched-link">${theseed1st_world_name} ${theseed1st_character_name} ${theseed1st_character_leve} ${theseed1st_character_class}</a>
								</div>
								
								<div class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link">
									<img src = ${theseed1st_character_image}></img></a>
									<!--  <div class="small text-white"><i class="fas fa-angle-right"></i></div>-->
								</div>
								
								<div class="card-footer">
									${theseed1st_floor}층
								</div>
								<div class="card-footer">
									${theseed1st_time_m}분 ${theseed1st_time_s}초
								</div>
								
						</div>
					</div>
					<div class="col-xl-2 col-md-6">
						<div class="card bg-secondary text-white mb-4">
							<div class="card-body">이번 주 업적 1위</div>
								<div class="card-footer">
									<a class="small text-white stretched-link">${achievement_world_name} ${achievement_character_name} ${achievement_character_leve} ${achievement_character_class}</a>
								</div>
								<div class="card-footer d-flex align-items-center justify-content-between">
									<a class="small text-white stretched-link"><img src = ${achievement_character_image}></img></a>
									<!--  div class="small text-white"><i class="fas fa-angle-right"></i></div>-->
								</div>
								<div class="card-footer">
									${achievement_getTrophy_grade}
								</div>
								<div class="card-footer"> 
									${achievement_getTrophy_score}점
								</div>
								
						</div>
					</div>
				</div>
			</div>
        </main>
    </div>
    <div id="layoutAuthentication_footer">
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid">
                <div class="d-flex align-items-center justify-content-between small">

                    <div>
                        <a href="#">Privacy Policy</a>
                        &middot;
                        <a href="#">Terms &amp; Conditions</a>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>

</body>
</html>