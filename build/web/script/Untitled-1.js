// JavaScript Document
//SLIDER
var anh=[];
var curr=0;
var tudong;
loadanh();
autoStart();
var nutanh=document.getElementsByName("sliderput");
nutanh[0].checked=true;
function loadanh(){
	for(var i=0;i<3;i++){
		anh[i]=new Image();
		anh[i].src="img/banner"+i+".jpg";
	}
}
function next(){
	curr++;
	if(curr==anh.length){
		curr=0;
	}
	var anhx=document.getElementById("slider");
	anhx.src=anh[curr].src;
	nutanh[curr].checked=true;
}
function autoStart(){
	tudong=setInterval(next,3500);
}

//FORM1

function checkloi(){
	var errorx=document.getElementById("errorfield");
	var userN=document.getElementById("tusername").value;
	if(userN.trim()==""){
		errorx.innerText="Tên đăng nhập trống";
		return;
	}
	errorx.innerText="";
	var passW=document.getElementById("tpassword").value;
	if(passW.trim()==""){
		errorx.innerText="Mật khẩu trống";
		return;
	}
	errorx.innerText="";
	document.getElementById("dangnhap").innerText="User: "+userN;
	document.getElementById("fDK").style.visibility="hidden";
	
	
}
//FORM2
function checkloi2(){
	var errorx=document.getElementById("errorfieldx");
	var userN=document.getElementById("txusername").value;
	if(userN.trim()==""){
		errorx.innerText="Tên đăng nhập trống";
		return;
	}
	errorx.innerText="";
	var passW=document.getElementById("txpassword").value;
	if(passW.trim()==""){
		errorx.innerText="Mật khẩu trống";
		return;
	}
	errorx.innerText="";
	var passWc=document.getElementById("txcpassword").value;
	if(passWc.trim()==""){
		errorx.innerText="Mật khẩu xác nhận trống";
		return;
	}
	errorx.innerText="";
	if(passW.trim()!=passWc.trim()){
		errorx.innerText="Mật khẩu xác nhận không trùng";
		return;
	}
	errorx.innerText="";
	var email=document.getElementById("txemail").value;
	if(email.trim()==""){
		errorx.innerText="Email trống";
		return;
	}
	errorx.innerText="";
	document.getElementById("fDK1").style.visibility="hidden";
	
}
function closef(x){
	var f=x.parentElement.parentElement;
	f.style.visibility="hidden";
}
function showlogin(){
	var f=document.getElementById("fDK");
	f.style.visibility="visible";
	var f=document.getElementById("fDK1");
	f.style.visibility="hidden";
}
function showregister(){
	var f=document.getElementById("fDK1");
	f.style.visibility="visible";
	var f=document.getElementById("fDK");
	f.style.visibility="hidden";
}
//giohang
var sanpham=[
	{tensp:"Rượu ong 100%",gia:5000000,},
	{tensp:"Whiskey 100", gia:8990000},
	{tensp:"Whiskey 101", gia:9990000},
	{tensp:"Whiskey 102", gia:10990000},
	{tensp:"Whiskey 103", gia:7990000},
	{tensp:"Whiskey 104", gia:6990000}
];
var giohangdata=[];
var tongtiensp=0;
tongtien();
function them(x){
	var sp=sanpham[x];
	if(giohangdata.length==0){
		var giohangi= {mathang:sp,soluong:1};
		giohangdata.push(giohangi);
//		console.log(JSON.stringify(giohangdata));
//		console.log(giohangdata.length);
		loadbang();
		thongbao();
		
	}
	else{
		for(var i=0;i<giohangdata.length;i++){
			if(giohangdata[i].mathang==sp){
				giohangdata[i].soluong++;
//				console.log(JSON.stringify(giohangdata));
//				console.log(giohangdata.length);
				loadbang();
				thongbao();
				break;
			}
		}
		if(giohangdata.length==i){
			var giohangi= {mathang:sp,soluong:1};
			giohangdata.push(giohangi);
//				console.log(JSON.stringify(giohangdata));
//				console.log(giohangdata.length);
			loadbang();
			thongbao();
		}
	}

}
function xoa(z){
	var conf=confirm("chac chan sua ko?");
	if(conf==true){
		var row=z.parentElement.parentElement;
	var indx=row.rowIndex-1;
//	console.log(indx);
//	console.log(JSON.stringify(giohangdata[indx-1]));
	giohangdata.splice(indx,1);
	loadbang();
	}
	
}
function loadbang(){
	var strg=`<tr style="background-color: green"><td>Tên sản phẩm</td>
						<td>Đơn giá</td>
						<td>Số lượng</td>
						<td>Thành tiền</td>
						<td></td></tr>`;
	var giohang=document.getElementById("giohang");
	for(let i=0;i<giohangdata.length;i++){
		strg+=`<tr>
			 	<td>${giohangdata[i].mathang.tensp}</td>
				<td>${giohangdata[i].mathang.gia}</td>
				<td>${giohangdata[i].soluong}</td>
				<td>${giohangdata[i].soluong*giohangdata[i].mathang.gia}</td>
				<td><button onclick="xoa(this);">Xoa</button></td>
			 </tr>`;
	}
	giohang.innerHTML=strg;
	tongtien();
}
function tongtien(){
	tongtiensp=0;
	for(let i=0;i<giohangdata.length;i++){
		tongtiensp+=giohangdata[i].mathang.gia*giohangdata[i].soluong;
	}
	document.getElementById("tongtien").innerText=tongtiensp;
	if(tongtiensp<=0){
		document.getElementById("cart").style.display="none";
	}
}
function showcart(){
	if(tongtiensp>0){
	document.getElementById("cart").style.display="";
	}
	else{
		thongbaocart();
	}
		
}
//thongbao
function thongbao(){
	$(document).ready(function(){
		$("#notif").fadeIn();
		$("#notif").fadeOut(2000);
	});
}
function thongbaocart(){
	$(document).ready(function(){
		$("#blank").fadeIn();
		$("#blank").fadeOut(2000);
	});
}




