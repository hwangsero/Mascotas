<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Shop Item - Start Bootstrap Template</title>

    <!-- Bootstrap core CSS -->
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="../../vendor/jquery/jquery.min.js"></script>
	
    <!-- Custom styles for this template -->
    <link href="../../css/shop-item.css" rel="stylesheet">
    <link rel="stylesheet" href="../../css/jquery.bxslider.css">
    <script src="../../vendor/jquery/jquery.bxslider.js"></script>
    <script>
	    $(document).ready(function(){
	      $('.bxslider').bxSlider({
	   	    mode: 'fade',
	//   	    captions: true,
	  	    slideWidth: 600
	      });
	    });
   </script>
	
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

    <!-- header -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    </nav>
    <!-- header -->

    <!-- Page Content -->
    <div class="container">
		<h1>찾았습니다</h1>
      <div class="row">

		<!-- margin-left -->
        <div class="col-lg-9" style="margin-left: 150px;">

          <div class="card mt-4">
            <div class="bxslider">
	            <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
	            <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
	            <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
            </div>
            <div class="card-body">
<!--               <h3 class="card-title">Product Name</h3> -->
              
<!--               <hr> -->
              <h4>기본정보</h4>
<!-- 	              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p> -->
	              <table class="table">
	              	<tr>
	              		<th>실종동물</th>
	              		<td>앵무새</td>
	              	</tr>
	              	<tr>
	              		<th>성별</th>
	              		<td>암컷</td>
	              	</tr>
	              	<tr>
	              		<th>나이</th>
	              		<td>5살</td>
	              	</tr>
	              	<tr>
	              		<th>동물이름</th>
	              		<td>까미</td>
	              	</tr>
	              	<tr>
	              		<th>실종날짜</th>
	              		<td>2018-11-15</td>
	              	</tr>
	              </table>
              <hr>
              <h4>실종장소</h4>
              <div id="map" style="width:500px;height:400px;"></div>
              <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1584c42b9181fdd1bc71aebde10ee750&libraries=services"></script>
				<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				    mapOption = {
				        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        level: 3 // 지도의 확대 레벨
				    };  
				
				// 지도를 생성합니다    
				var map = new daum.maps.Map(mapContainer, mapOption); 
				
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new daum.maps.services.Geocoder();
				
				// 입력한 위치 
				var addr = "서울시 서초구";
				
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch(addr, function(result, status) {
				
				    // 정상적으로 검색이 완료됐으면 
				     if (status === daum.maps.services.Status.OK) {
				
				        var coords = new daum.maps.LatLng(result[0].y, result[0].x);
				
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new daum.maps.Marker({
				            map: map,
				            position: coords
				        });
				
				
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});    
				</script>
              <hr>
              <h4>특징</h4>
	              <p class="card-text">다른 왕관앵무에비해 발이크고 여자분이나어린아이를 좋아해 어깨에 잘앉습니다</p>
              <hr>
              <h4>연락처</h4>
	              <table class="table">
	              	<tr>
	              		<th>닉네임</th>
	              		<td>모모까미</td>
	              	</tr>
	              	<tr>
	              		<th>전화번호</th>
	              		<td>010-0000-1111</td>
	              	</tr>
	              	<tr>
	              		<th>기타</th>
	              		<td>모모까미님에게 쪽지보내기 이메일보내기</td>
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
    
    <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>
</html>