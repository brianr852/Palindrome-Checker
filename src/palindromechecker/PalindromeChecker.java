/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromechecker;

/**
 *
 * @author brian
 */

import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker
{
    /**
     * Tests whether a string is a palindrome, ignoring punctuation, spaces, and case.
     *
     * @param input a string to check
     */
    public boolean isPalindrome(String input)
    {
        Stack<Character> stringStack = new Stack<Character>();
        input = input.toUpperCase().replaceAll("[!,.?;:/ ]" , "");
        int halfString = input.length() / 2;
        int index = 0;
        boolean result = true;

        //check if index is less than half - push and adjust index by 1
        for (;index < halfString; index++)
        {
            stringStack.push(input.charAt(index));
        }

        //if replaced is odd, adjust index by 1
        if( input.length() % 2 == 1)
        {
            index++;
        }

        //while stack is not empty
        //if characters from replaceString matches half of stack
        //adjust index by 1
        //else result is false
        while( !stringStack.empty())
        {
            if( stringStack.pop().equals(input.charAt(index)))
            {
                index++;
            }
            else
            {
                result = false;
            }
        }

        return result;
    } // end isPalindrome

    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        PalindromeChecker pc = new PalindromeChecker();

        //Describe the program and how it works
        System.out.println("*** This program determines whether a string is a palindrome. ");
        System.out.println("A palindrome is spelled the same from left to right as it is from right to left,");
        System.out.println("if we ignore punctuation, spaces, and case. ***");

        System.out.println("\nEnter a string that you want to check (or enter \"stop\" to stop): ");
        String input = keyboard.nextLine();

        while (!input.equalsIgnoreCase("stop"))
        {
            if (pc.isPalindrome(input))
                System.out.println("\"" + input + "\" is a palindrome!");
            else
                System.out.println("\"" + input + "\" is not a palindrome!");

            System.out.println("\nEnter a string that you want to check (or enter \"stop\" to stop): ");
            input = keyboard.nextLine();
        } // end while

        System.out.println("Done!");
    } // end main
} // end PalindromeChecker
