def checkNumber(num):
    """Check if number is EVEN, ODD, Divisible by 3 and/or Divisible by 5

    Args:
        num (int): Value to check
    """    
    if num % 2 == 0:
        result = 'even'
    else:
        result = 'odd'
    if num % 3 == 0:
        result += ' div 3'
    if num % 5 == 0:
        result += ' div 5'
    print(f'{num}: {result}')

def display_number_report(start, stop):
    """ Display all the whole numbers between the start and stop values inclusively.  
    Call func checkNumber(), print report

    Args:
        start (int): First whole number
        stop (int): Last whole number

    Returns:
        None
    """    
    if start > stop:                # Descending order
        while start >= stop:
            checkNumber(start)
            start -= 1
    else:                           # Equal or Ascending order
        while start <= stop:
            checkNumber(start)
            start += 1
    return None

# Test Case - 1
display_number_report(1,7)
print()
return_value = display_number_report(3,3)
print(return_value)
print('\n## END - Test 1 ##\n')
# Test Case - 2
print(display_number_report(start=20, stop=10))
print()
display_number_report(1,5)
print('\n## END - Test 2 ##\n')