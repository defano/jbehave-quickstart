// Indicates whether the display has been updated by the user. 
var dirty = false;

/**
 * Appends the string 'value' to the calculator's display. If this is the first
 * time appendToDisplay() is being called since the page was loaded, this 
 * function replaces the value in the display.
 * 
 * @param value The string to append/insert into the display.
 */
function appendToDisplay (value) {
	
	if (!dirty) {
		dirty = true;
		$("[name=displayedValue]").val(value);
	} else {	
		$("[name=displayedValue]").val($("[name=displayedValue]").val() + value);
	}
}

/**
 * Clear the display; reset's the displayed value to zero.
 */
function clearDisplay () {	
	$("[name=displayedValue]").val("0");
}

/**
 * Updates the hidden form field with the selected operator, then submits the
 * form to the server.
 * 
 * @param operator The operator chosen that caused the submit. Must match one
 * of the enumerated values defined in com.sta.jbehave.calculator.model.Operator.
 */
function formSubmit (operator) {
	$("[name=operator]").val(operator);
	$("[name=calculator]").submit();
}
