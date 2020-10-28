<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
 <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Round About - Start Bootstrap Template</title>

    <link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

  </head>
	<style type="text/css">
	/*    --------------------------------------------------
	:: General
	-------------------------------------------------- */
body {
	font-family: 'Open Sans', sans-serif;
	color: #353535;
}
.content h1 {
	text-align: center;
}
.content .content-footer p {
	color: #6d6d6d;
    font-size: 12px;
    text-align: center;
}
.content .content-footer p a {
	color: inherit;
	font-weight: bold;
}

/*	--------------------------------------------------
	:: Table Filter
	-------------------------------------------------- */
.panel {
	border: 1px solid #ddd;
	background-color: #fcfcfc;
}
.panel .btn-group {
	margin: 15px 0 30px;
}
.panel .btn-group .btn {
	transition: background-color .3s ease;
}
.table-filter {
	background-color: #fff;
	border-bottom: 1px solid #eee;
}
.table-filter tbody tr:hover {
	cursor: pointer;
	background-color: #eee;
}
.table-filter tbody tr td {
	padding: 10px;
	vertical-align: middle;
	border-top-color: #eee;
}
.table-filter tbody tr.selected td {
	background-color: #eee;
}
.table-filter tr td:first-child {
	width: 50px;
}
.table-filter tr td:nth-child(2) {
	width: 1100px;
}
.ckbox {
	position: relative;
}
.ckbox input[type="checkbox"] {
	opacity: 0;
}
.ckbox label {
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}
.ckbox label:before {
	content: '';
	top: 1px;
	left: 0;
	width: 18px;
	height: 18px;
	display: block;
	position: absolute;
	border-radius: 2px;
	border: 1px solid #bbb;
	background-color: #fff;
}
.ckbox input[type="checkbox"]:checked + label:before {
	border-color: #2BBCDE;
	background-color: #2BBCDE;
}
.ckbox input[type="checkbox"]:checked + label:after {
	top: 3px;
	left: 3.5px;
	content: '\e013';
	color: #fff;
	font-size: 11px;
	font-family: 'Glyphicons Halflings';
	position: absolute;
}
.table-filter .star {
	color: #ccc;
	text-align: center;
	display: block;
}
.table-filter .star.star-checked {
	color: #F0AD4E;
}
.table-filter .star:hover {
	color: #ccc;
}
.table-filter .star.star-checked:hover {
	color: #F0AD4E;
}
.table-filter .media-photo {
	width: 180px;
	height: 180px;
}
.table-filter .media-body {
    display: inline-block;
    /* Had to use this style to force the div to expand (wasn't necessary with my bootstrap version 3.3.6) */
}
.table-filter .media-meta {
	font-size: 11px;
	color: #999;
}
.table-filter .media .title {
	color: #2BBCDE;
	font-size: 14px;
	font-weight: bold;
	line-height: normal;
	margin: 0;
}
.table-filter .media .title span {
	font-size: .8em;
	margin-right: 20px;
}
.table-filter .media .title span.pagado {
	color: #5cb85c;
}
.table-filter .media .title span.pendiente {
	color: #f0ad4e;
}
.table-filter .media .title span.cancelado {
	color: #d9534f;
}
.table-filter .media .summary {
	font-size: 14px;
}
	</style>
	<script>
	$(document).ready(function () {

		$('.star').on('click', function () {
	      $(this).toggleClass('star-checked');
	    });

	    $('.ckbox label').on('click', function () {
	      $(this).parents('tr').toggleClass('selected');
	    });

	    $('.btn-filter').on('click', function () {
	      var $target = $(this).data('target');
	      if ($target != 'all') {
	        $('.table tr').css('display', 'none');
	        $('.table tr[data-status="' + $target + '"]').fadeIn('slow');
	      } else {
	        $('.table tr').css('display', 'none').fadeIn('slow');
	      }
	    });

	 });
	

	</script>

  <body>
  <jsp:include page="../../include/header.jsp"></jsp:include></span>
   <div class="container">
	<div class="row">

		<section class="content">
			<h1>찾&nbsp;아&nbsp;주&nbsp;세&nbsp;요</h1>
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="pull-right">
						</div>
						<div class="table-container">
							<table class="table table-filter" border="1">
								<tbody>
								<tr data-status="pagado">
										<!-- .table-filter tr td:first-child -->
										<th align="center">
											번호
										</th>
										<!-- .table-filter tr td:nth-child(2) -->
										<th align="center">
											내 &nbsp;&nbsp;용
										</th>
										<th align="center">
											작성자
										</th>
										<th align="center">
											등록일
										</th>
									</tr>
									
									<c:forEach items="${ findPlzList }" var="board">
									<tr data-status="pagado">
										<td align="center">
											${ board.no }
										</td>
										<!-- .table-filter tr td:nth-child(2) -->
										<td>
											<div class="media">
												<a href="<%=request.getContextPath()%>/menu/findPlzDetail.do?no=${board.no}" class="pull-left">
													<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo" style="float: left; padding-right: 10px;" >
												</a>
												<!-- .table-filter .media-body -->
												<div >
													품종 : ${board.race }<br>
													실종일자 : ${board.lostDate }<br>
													실종장소 : ${board.lostSpot }<br>
													특징 : ${board.feature }<br>
													
												</div>
											</div>
										</td>
										<td align="center">
											
										${board.writer }
										</td>
										<td align="center">
										${board.reg_date }
											
										</td>
									</tr>
									</c:forEach>
									
									<tr data-status="pagado">
										<td>
											1
										</td>
										<!-- .table-filter tr td:nth-child(2) -->
										<td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<h4 class="title">
														Lorem Impsum
													</h4>
													<p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
												</div>
											</div>
										</td>
										<td>
											
										</td>
										<td>
											
										</td>
									</tr>
									<tr data-status="pagado">
										<td>
											1
										</td>
										<!-- .table-filter tr td:nth-child(2) -->
										<td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<h4 class="title">
														Lorem Impsum
													</h4>
													<p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
												</div>
											</div>
										</td>
										<td>
											
										</td>
										<td>
											
										</td>
									</tr>
									<tr data-status="pagado">
										<td>
											1
										</td>
										<!-- .table-filter tr td:nth-child(2) -->
										<td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<h4 class="title">
														Lorem Impsum
													</h4>
													<p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
												</div>
											</div>
										</td>
										<td>
											
										</td>
										<td>
											
										</td>
									</tr>
									<tr data-status="pagado">
										<td>
											1
										</td>
										<!-- .table-filter tr td:nth-child(2) -->
										<td>
											<div class="media">
												<a href="#" class="pull-left">
													<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<h4 class="title">
														Lorem Impsum
													</h4>
													<p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
												</div>
											</div>
										</td>
										<td>
											
										</td>
										<td>
											
										</td>
									</tr>
									<tr data-status="pagado">
										<td>
											1
										</td>
										<!-- .table-filter tr td:nth-child(2) -->
										<td>
											<div class="media">
												<a href="#" class="pull-left">
												<!-- .table-filter .media-photo -->
													<img src="https://s3.amazonaws.com/uifaces/faces/twitter/fffabs/128.jpg" class="media-photo">
												</a>
												<div class="media-body">
													<h4 class="title">
														Lorem Impsum
													</h4>
													<p class="summary">Ut enim ad minim veniam, quis nostrud exercitation...</p>
												</div>
											</div>
										</td>
										<td>
											
										</td>
										<td>
											
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="content-footer">
					<p>
						Page © - 2016 <br>
						Powered By <a href="https://www.facebook.com/tavo.qiqe.lucero" target="_blank">TavoQiqe</a>
					</p>
				</div>
			</div>
		</section>
		
	</div>
</div>

  </body>
</html>