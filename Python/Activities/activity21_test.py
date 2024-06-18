import pytest

# Additon test
def test_addition():
	
    # Initialize two numbers
	num1 = 10
	num2 = 20
    
	# Add them
	sum = num1 + num2

	# Assertion
	assert sum == 30

# Subtraction test
def test_subtraction():
  
	# Initialize two numbers
	num1 = 50
	num2 = 25
    
	# Subtract them
	diff = num1 - num2

	# Assertion
	assert diff == 25

# Multiplication test
def test_multiplication():
  
	# Initialize two numbers
	num1 = 5
	num2 = 10
    
	# Multiply them
	prod = num1 * num2

	# Assertion
	assert prod == 50

# Division test
def test_division():
  
	# Initialize two numbers
	num1 = 100
	num2 = 50
    
	# Divide them
	quot = num1 / num2

	# Assertion
	assert quot == 2