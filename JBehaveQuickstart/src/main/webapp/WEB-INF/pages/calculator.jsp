<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculator</title>
<link rel="stylesheet" type="text/css"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/calculator.css" />
</head>

<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="js/calculator.js"></script>

<body>

	<form name="calculator">

		<input type="hidden" name="operator" />
		<input type="hidden" name=subtotal value="${calculator.subtotal}"/>
		<input type="hidden" name="lastOperator" value="${calculator.lastOperator}"/>
		
		<table class="tg-table-plain">
			<tr>
				<td class="display" colspan="4"><div><input class="display" type="text" name="displayedValue" readonly value="${calculator.displayedValue}"></div></td>
			</tr>
			<tr>
				<td class="td-grey" onClick="clearDisplay()">C</td>
				<td class="td-grey" onClick="formSubmit('NEGATE')">+/-</td>
				<td class="td-grey" onClick="formSubmit('PERCENT')">%</td>
				<td class="td-orange" onClick="formSubmit('DIVIDE')">/</td>
			</tr>
			<tr class="tg-even">
				<td class="td-lightgrey" onClick="appendToDisplay('7')">7</td>
				<td class="td-lightgrey" onClick="appendToDisplay('8')">8</td>
				<td class="td-lightgrey" onClick="appendToDisplay('9')">9</td>
				<td class="td-orange" onClick="formSubmit('MULTIPLY')">X</td>
			</tr>
			<tr>
				<td class="td-lightgrey" onClick="appendToDisplay('4')">4</td>
				<td class="td-lightgrey" onClick="appendToDisplay('5')">5</td>
				<td class="td-lightgrey" onClick="appendToDisplay('6')">6</td>
				<td class="td-orange" onClick="formSubmit('SUBTRACT')">-</td>
			</tr>
			<tr class="tg-even">
				<td class="td-lightgrey" onClick="appendToDisplay('1')">1</td>
				<td class="td-lightgrey" onClick="appendToDisplay('2')">2</td>
				<td class="td-lightgrey" onClick="appendToDisplay('3')">3</td>
				<td class="td-orange" onClick="formSubmit('ADD')">+</td>
			</tr>
			<tr>
				<td colspan="2" class="td-lightgrey" onClick="appendToDisplay('0')">0</td>
				<td class="td-lightgrey" onClick="appendToDisplay('.')">.</td>
				<td class="td-orange" onClick="formSubmit('EQUALS')">=</td>
			</tr>
		</table>

	</form>

</body>
</html>