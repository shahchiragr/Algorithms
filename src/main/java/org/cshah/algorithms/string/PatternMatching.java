package org.cshah.algorithms.string;

/**
 * Created by cshah on 5/8/14.
 */
public class PatternMatching {

    private boolean isMatched(char[] regex, char[] str, int r, int s) {
        if (str.length == s  && regex.length == r) {
            return true;
            // Match is true when regex is exhausted or it's last char is "*" - allowing optional str
            //return regex.length == 0 || regex.charAt(regex.length() - 1) == '*';
        } else if (regex.length == r) {
            return true;
        } else if (regex[r] == '*' && regex.length +1 <= r &&  str.length == s ) {
            return true;
        } else if (regex[r]== '*' && regex.length +1 <= r && regex[r+1] != str[s] && regex[r-1] != str[s]) {
            return false;
        }  else if (regex[r] == '*' ) {
            return  isMatched(regex, str, r+1, s) || isMatched(regex, str, r, s+1) ;
        }  else if (isCharMatched(regex[r], str[s])) {
            return isMatched(regex, str, r+1, s+1);
        }  else  if (!isCharMatched(regex[r], str[s]) && regex.length +1 <= r && regex[r+1] == '*') {
            return  isMatched(regex, str, r+2, s);
        }  else if (regex[r] == '+') {
              return  isMatched(regex, str, r+1, s) || isMatched(regex, str, r, s+1);
        }

              return  false;
        /*
        if (regex.length() == 0) {
            // Match is true only if str is fully consumed
            return str.length() == 0;
        }
        Character curReg = regex.charAt(0);
        Character nextReg = regex.length() >= 2 ? regex.charAt(1) : null;
        Character curStr = str.length() != 0 ? str.charAt(0) : null;

        if (nextReg == null || (nextReg != '*' && nextReg != '+')) {
            // This is a simple match - just take the first char from both regex and str and recurse IFF current match is detected
            return isCharMatched(curReg, curStr) && isMatched(regex.substring(1), str.substring(1));
        } else {
            if (nextReg == '*') {
                // The current regex char is followed by "*" - create 2 branches:
                // - one with unmodified regex and reduced str IFF current match detected - meaning to continue repetition if possible
                // - the other one with reduced regex and unmodified str - meaning to try out the optional nature of "*"
                return (isCharMatched(curReg, curStr) && isMatched(regex, str.substring(1)))
                        || isMatched(regex.substring(2), str);
            } else if (nextReg == '+') {
                // The current regex char is followed by "+" - reduce to 1 branch with "*" instead of "+"
                return isCharMatched(curReg, curStr) && isMatched(curReg + "*" + regex.substring(2), str.substring(1));
            } else {
                return false;
            }
        }
        */
    }

    public boolean isMatched(String regex, String str) {
        return isMatched(regex.toCharArray(), str.toCharArray(), 0,0);
    }
    private boolean isCharMatched(Character regexCh, Character strCh) {
        return regexCh == strCh || (regexCh == '.' && strCh >= 'a' && strCh <='z');
    }

    public boolean isMatched2(String s, String p) {
        if (p.length() == 0)
            return  s.length() ==0;

        if (p.length() ==1 || p.charAt(1) != '*') {
            if (s.length() < 1 || ( p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)  ) )
                return  false;

            return isMatched2(s.substring(1),p.substring(1));
        } else  {
            int len = s.length();
            int i = -1;
            while (i < len && (i <0 || p.charAt(0) != '.' || p.charAt(0) == s.charAt(0))) {
                if (isMatched2(s.substring(i+1), p.substring(2)))
                    return  true;
                i++;
            }
        }
        return  false;
    }

    public static void main(String args[]) {
        PatternMatching matching = new PatternMatching();

        System.out.println("HERE " + matching.isMatched2("aaabc", "a*b*"));
        /*
        System.out.println( matching.isMatched("a*b", "aab") );
        System.out.println( matching.isMatched("a**b", "aab") );
        System.out.println( matching.isMatched("a+b", "aab") );

        System.out.println(matching.isMatched("a*b", "aaaab")); // Yes - correct
        System.out.println(matching.isMatched("a+bc*", "bccc")); // No - correct
        System.out.println(matching.isMatched("ab+cd*", "abbcdd")); // Yes - correct
        System.out.println(matching.isMatched("c*a*b", "aab")); // No - wrong
        System.out.println(matching.isMatched("a*b", "b")); // No - wrong
    //    System.out.println(matching.isMatched("a+a*b*", "ab")); // No - wrong
        System.out.println(matching.isMatched("aa*b*ab+", "aab")); // No - wrong
*/

    }
}
