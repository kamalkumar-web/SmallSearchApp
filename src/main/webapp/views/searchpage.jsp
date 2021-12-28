<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#searchCustomers').click(function(){
			var customerDetails = {
					firstName: $("#firstName").val(),
					lastName: $("#lastName").val(),
				    };
				$.ajax({
					type: 'POST',
					url:"getCustomersByCondition",
					data:customerDetails,
					dataType:"json",
					success:function(response){
						 var trHTML = '';
					        $.each(response, function (singleEntry, singleCustomer) {
					            trHTML += '<tr><td>' + singleCustomer.customerId 
					            + '</td><td>' + singleCustomer.firstName 
					            + '</td><td>' + singleCustomer.lastName 
					            + '</td></tr>';
					        });
					        $("#customerDetailsId").empty();
					        $('#customerDetailsId').append(trHTML);
					}
				})
			})
		})
		
		//all customer data
		$(document).ready(function(){
		$('#AllCustomers').click(function(){
				$.ajax({
					url:"getAllCustomers",
					dataType:"json",
					success:function(response){
						 var trHTML = '';
					        $.each(response, function (singleEntry, singleCustomer) {
					            trHTML += '<tr><td>' + singleCustomer.customerId 
					            + '</td><td>' + singleCustomer.firstName 
					            + '</td><td>' + singleCustomer.lastName 
					            + '</td></tr>';
					        });
					        $("#customerDetailsId").empty();
					        $('#allCustomers').append(trHTML);
					}
				})
			})
		})

</script>
</head>
<body>
	<form method="post">
		<label for="firstName">First Name</label>
		<input type="text" name="firstName" id="firstName"><br>
		<label for="lastName">Last Name</label>
		<input type="text" name="lastName" id="lastName"><br>
		<input id="searchCustomers" type="button" name="searchbtn" Value="Search Now"><br>
		<input id="AllCustomers" type="button" name="allCustomer" Value="Display All Customer Data"><br>
	</form>
	
<table id="customerDetailsId">
  <tr>
    <th>CustomerId</th>
    <th>First Name</th> 
    <th>Last Name</th>
  </tr>
</table>

<br><br><br><br><br><br><br><br>
<table id="allCustomers">
<thead><h3>All Customers In DataBase</h3></thead>
  <tr>
    <th>CustomerId</th>
    <th>First Name</th> 
    <th>Last Name</th>
  </tr>
</table>
</body>
</html>