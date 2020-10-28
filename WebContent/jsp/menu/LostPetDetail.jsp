<%@page import="miniproject.vo.AnimalVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String desertionNo = request.getParameter("no");
	List<AnimalVO> arlist = (List)session.getAttribute("alist");
	for(int i=0;i<arlist.size();i++){
		if(arlist.get(i).getDesertionNo().equals(desertionNo)){
			AnimalVO ao = arlist.get(i);
			pageContext.setAttribute("ao", ao);
		}
	}
%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  </head>
<style>
.table {
    width: 100%;
    border: 1px solid #444444;
  }
  th, td {
    border: 1px solid #444444;
  }
</style>
  <body>
	<img src=>
    <!-- header -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    </nav>
    <!-- header -->

    <!-- Page Content -->
    <div class="container">
      <div class="row">

		<!-- margin-left -->
        <div class="col-lg-9" style="margin-left: 150px;">

          <div class="card mt-4">
          <div class="bxslider">
            <img class="card-img-top img-fluid" src=${ao.popfile} alt="">
          </div>
            <div class="card-body">
<!--               <h3 class="card-title">Product Name</h3> -->
              
<!--               <hr> -->
              <h4>기본정보</h4>
<!-- 	              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p> -->
	              <table class="table">
	              	<tr>
	              		<th>실종동물</th>
	              		<td>${ao.kind}</td>
	              	</tr>
	              	<tr>
	              		<th>성별</th>
	              		<td>${ao.sex}</td>
	              	</tr>
	              	<tr>
	              		<th>나이</th>
	              		<td>${ao.age}</td>
	              	</tr>
	              	<tr>
	              		<th>발견장소</th>
	              		<td>${ao.findplace}</td>
	              	</tr>
	              	<tr>
	              		<th>공고 날짜</th>
	              		<td>${ao.noticeSdt}</td>
	              	</tr>
	              </table>
              <hr>
              <h4>보호소장소</h4>
              <div id="map" style="width:500px;height:400px;"></div>
              <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1584c42b9181fdd1bc71aebde10ee750&libraries=services"></script>
				<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
						text: "${ao.careAddr}",
				        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };  
				
				// 지도를 생성합니다    
				var map = new daum.maps.Map(mapContainer, mapOption); 
				
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new daum.maps.services.Geocoder();
				
				// 입력한 위치 
				var add = "${ao.careAddr}";
				/* if(add.match("동")){
					add = (add.split("동")[0]+"동");
				}
				console.log(add); */
				var addr = add;
				
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(addr, function(result, status) {
				
				    // 정상적으로 검색이 완료됐으면 
				     if (status === daum.maps.services.Status.OK) {
				
				        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
				        var iwContent = '<div style="padding:5px;">${ao.careAddr}<br><a href="http://map.daum.net/link/search/${ao.careAddr}" style="color:blue" target="_blank">길찾기</a></div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new daum.maps.Marker({
				        	
				            map: map,
				            position: coords,
				            
				        });
				        var infowindow = new daum.maps.InfoWindow({
				            position : coords, 
				            content : iwContent 
				        });
				
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        infowindow.open(map, marker);
				        map.setCenter(coords);
				    } 
				});    
				</script>
              <hr>
              <h4>특징</h4>
	              <p class="card-text">${ao.feature}<br>${ao.processState}</p>
              <hr>
              <h4>연락처</h4>
	              <table class="table">
	              	<tr>
	              		<th>담당자</th>
	              		<td>${ao.office}</td>
	              	</tr>
	              	<tr>
	              		<th>전화번호</th>
	              		<td>${ao.officetel}</td>
	              	</tr>
	              	<tr>
	              		<th>보호소</th>
	              		<td>${ao.careAddr} ${ao.careNM} </td>
	              	</tr>
	              	<tr>
	              		<th>보호소 전화번호</th>
	              		<td>${ao.careTel}</td>
	              	</tr>
	              </table>
              <hr>
            </div>
          </div>
          <!-- /.card -->

          <div class="card card-outline-secondary my-4">
            <div class="card-header">
              Product Reviews
            </div>
            <div class="card-body">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore, similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum. Sequi mollitia, necessitatibus quae sint natus.</p>
              <small class="text-muted">Posted by Anonymous on 3/1/17</small>
              <hr>
              <a href="#" class="btn btn-success">Leave a Review</a>
            </div>
          </div>
          <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    

  </body>
</html>