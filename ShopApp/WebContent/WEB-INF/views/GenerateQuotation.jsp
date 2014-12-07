<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
		
		           <style>
	.table {
width: 25%;
margin-bottom: 20px;
}

 </style>
		
	</head>

<body >

	<form class="form-horizontal">
		<fieldset>

			<!-- Form Name -->
			<legend>Add Quotation</legend>
<center>
			<!-- Select Basic -->
			<table border="1"  >
				<tr>
					<td>
						<div class="control-group">
							<label class="control-label" for="selectbasic">Unit</label>
								<select id="selectbasic" name="selectbasic" class="input-large">
									<option>Option one</option>
									<option>Option two</option>
								</select>
						</div>
					</td>
				
					<td>
						<!-- Text input-->
						<div class="control-group">
							<label class="control-label" for="qnocode">Quotation No</label>
								<input id="qnocode" name="qnocode" type="text" placeholder=""
									class="input-mini"> <input id="qnumber" name="qnumber"
									type="text" placeholder="" class="input-small"> Date
							</div>
					</td>
				
				</tr>
				<tr>
					<td>
						<!-- Select Basic -->
						<div class="control-group">
							<label class="control-label" for="qtype">Quotation Type</label>
								<select id="qtype" name="qtype" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select>
							</div>
					</td>
					<td>
						<!-- Select Basic -->
						<div class="control-group">
							<label class="control-label" for="partyName">Party Name</label>
								<select id="partyName" name="partyName" class="input-xlarge">
									<option>Option one</option>
									<option>Option two</option>
								</select>
							</div>
					</td>
				</tr>
				<tr>
					<td>
						<!-- Textarea -->
						<div class="control-group">
							<label class="control-label" for="deliveryAddress">Delivery
								Address</label>
								<textarea id="deliveryAddress" name="deliveryAddress"></textarea>
						</div>
					</td>
					<td>
										
						<div class="control-group">
							<label class="control-label" for="bookedBy">Booked By</label>
								<select id="bookedBy"
									name="bookedBy" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
						</div>
						
						
					</td>
					
				</tr>
				<tr >
					<td colspan="2">
						<!-- Text input-->
						<div class="form-horizontal">
							<div class="control-group row-fluid form-inline">

								<label for="phoneNo">Phone No</label> <input id="phoneNo"
									name="phoneNo" type="text" class="input-medium"> <label
									for="prepairedBy">Preapaired By</label> <input id="prepairedBy"
									name="prepairedBy" type="text" class="input-medium"> <label
									for="currency">Currency</label> <select id="currency"
									name="currency" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="custRefNo">Cust Ref No</label> <input
									id="custRefNo" name="custRefNo" type="text"
									class="input-medium">
							</div>

						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="form-horizontal">
							<div class="control-group row-fluid form-inline">
								<label for="paymentMode">Payment Mode </label> <select
									id="paymentMode" name="paymentMode" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="encloser">Encloser</label> <select id="encloser"
									name="encloser" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="roadPermit">Road Permit</label> <select
									id="roadPermit" name="roadPermit" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="deleveryMode">Delevery Mode</label> <select
									id="deleveryMode" name="deleveryMode" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select>

							</div>
						</div>
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<div class="form-horizontal">
							<div class="control-group row-fluid form-inline">
								<label for="application">Application </label> <select
									id="application" name="application" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="staxform">Stax Form</label> <select id="staxform"
									name="staxform" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="form-horizontal">
							<div class="control-group row-fluid form-inline">
								<label for="ratePer">Rate Per</label> <select id="ratePer"
									name="ratePer" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="showDiscount">Show Discount</label> <select
									id="showDiscount" name="showDiscount" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="discount">Discount %</label> <input id="discount"
									name="discount" type="text" placeholder="" class="input-small">

							</div>

						</div>

					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="form-horizontal">
							<div class="control-group row-fluid form-inline">
								<label for="rTable">RTable</label> <select id="rTable"
									name="rTable" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="sTable">STable</label> <select id="sTable"
									name="sTable" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select> <label for="exTable">EXTable</label> <select id="exTable"
									name="exTable" class="input-medium">
									<option>Option one</option>
									<option>Option two</option>
								</select>
							</div>
						</div>
					</td>
				</tr>
			</table>
			</center>
			
		</fieldset>
	</form>
</body>
</html>
