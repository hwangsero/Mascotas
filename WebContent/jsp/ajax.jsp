<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="miniproject.vo.AnimalVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
       <script>
         $(document).ready(function(){
            /* 프로토콜 */
            var protocol = (window.location.protocol === 'http:' ? 'http:' : 'https:');
            /* 기본 url */
            var url = 'http://openapi.animal.go.kr/openapi/service/rest/abandonmentPublicSrvc/';
            /* 호출 api 종류*/
            var parameter = 'abandonmentPublic';
            /* 인증키 */
            var params = 'serviceKey=Aijc7heSY0CpUFjf8ExZRtZXuIEXnuZnCKxAAcJu4al4y5R7OCAxhsI026SfK%2FIT9XfMRRADcxJnQKlKngDWyQ%3D%3D&upkind=429900';
            
            var urls = url + parameter;
            
            $.ajax({
               url : protocol + '//cors-anywhere.herokuapp.com/' + urls,  // cross domain 해결 url 추가
               type : 'get',
               data : decodeURI(params),
               success : function(data) {
            	   console.log(data);
                   $(data).find('item').each(function(index){  // xml 문서 item 기준으로 분리후 반복
                    var desertionNo = $(data).find('item').find('desertionNo')[index]; //유기번호
                 	var age= $(data).find('item').find('age')[index];				   //나이
                 	var happendate= $(data).find('item').find('happenDt')[index];	   //잃어버린날
                 	var findplace= $(data).find('item').find('happenPlace')[index];	   //발견된날
                 	var kind= $(data).find('item').find('kindCd')[index];			   //품종
                 	var color= $(data).find('item').find('colorCd')[index];			   //색상
                 	var weight= $(data).find('item').find('weight')[index];			   //무게
                 	var Feature= $(data).find('item').find('specialMark')[index];	   //특징
                 	var careNM= $(data).find('item').find('careNm')[index];			   //보호소이름
                 	var careTel= $(data).find('item').find('careTel')[index];		   //보호소 전화번호
                 	var careAddr= $(data).find('item').find('careAddr')[index];		   //보호 장소
                 	var office= $(data).find('item').find('chargeNm')[index];		   //담당자
                 	var officetel= $(data).find('item').find('officetel')[index]; 	   //담당자 연락처
                 	var processState= $(data).find('item').find('processState')[index];//현재 상태
                 	var filename= $(data).find('item').find('filename')[index]; 	   //썸네일 사진 경로
                 	var popfile= $(data).find('item').find('popfile')[index];		   //사진 경로
                 	var sex= $(data).find('item').find('sexCd')[index];				   //성별
                 	var neuter= $(data).find('item').find('neuterYn')[index];		   //중성화 여부
                 	var notice= $(data).find('item').find('specialMark')[index];	   //특이사항
                 	var noticeNo= $(data).find('item').find('noticeNo')[index];		   //공고번호
                 	var noticeSdt= $(data).find('item').find('noticeSdt')[index];	   //공고시작일
                 	var noticeEdt= $(data).find('item').find('noticeEdt')[index];	   //공고종료일
                 	console.log(desertionNo,age,happendate,findplace,kind,color,weight,Feature,careNM,careTel,careAddr,office,officetel,processState,filename,popfile,sex,neuter,notice,noticeNo,noticeSdt,noticeEdt)
                  });
               },
               error : function(result) {
                  alert('실패');
               }
            });
         });
      </script>