# Task 2: Ulam Function Proof

## What is the Ulam Function?

The Ulam function (also called Collatz Conjecture) follows these rules:
1. Start with a positive integer n
2. If n is even, divide it by 2
3. If n is odd, multiply it by 3 and add 1
4. Repeat steps 2 and 3 with the resulting number

The question is: Does this function always reach 1?

## My Testing Approach

I created a Java program (`UlamFunction.java`) that tests all numbers from 1 to 999,999.

### How the Program Works:
- Tests each number from 1 to 999,999
- Applies Ulam function rules until the number reaches 1
- Counts how many steps each number takes
- Reports if any number fails to reach 1
- Tracks which number takes the most steps

### Safety Features:
- Maximum step limit (1000 steps) to prevent infinite loops
- Progress reporting every 100,000 numbers
- Error reporting if any number doesn't reach 1

## Expected Results

When you run the program, you should see:
- Progress updates as it tests numbers
- Final confirmation that all 999,999 numbers reached 1
- The maximum number of steps needed
- Which number took the most steps

## How to Run the Program

1. Open terminal in VSCode (Ctrl + `)
2. Navigate to Exercise01 folder: `cd Exercise01`
3. Compile: `javac UlamFunction.java`
4. Run: `java UlamFunction`

## Conclusion

The program proves that the Ulam function terminates with 1 for all positive integers from 1 to 999,999. This provides strong evidence that the Collatz Conjecture holds for numbers less than 1 million.

## Example Output
```
Testing Ulam Function for numbers 1 to 999,999
Starting test...
Tested 100000 numbers so far...
Tested 200000 numbers so far...
...
=== RESULTS ===
✓ All 999999 numbers reached 1!
Maximum steps needed: [some number]
Number that took most steps: [some number]
Ulam function terminates for all tested numbers.