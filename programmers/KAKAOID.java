// 문제 링크 : https://programmers.co.kr/learn/courses/30/lessons/72410

// 다른 사람 풀이 (코드가 아름답다..)
class Solution {
    public String solution(String new_id) {

        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}


---

// 나의 풀이
import java.util.regex.Pattern;

class Solution {
    public String solution(String new_id) {
        new_id = step1(new_id);
        new_id = step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        new_id = step5(new_id);
        new_id = step6(new_id);
        new_id = step7(new_id);
        
        return new_id;
    }

    private static String step1(String new_id) {
        String result = "";
        for (int i = 0; i < new_id.length(); i++){
            result += (new_id.charAt(i) + "").toLowerCase();
        }
        return result;
    }

    private static String step2(String new_id) {
        String result = "";
        // 정규표현식 - 소문자, 숫자, 빼기, 밑줄, 마침표 제외
        String check = "[a-z0-9\\-._]";
        for (int i = 0; i < new_id.length(); i++) {
            if (Pattern.matches(check, new_id.charAt(i)+""))
                result += new_id.charAt(i) + "";
        }
        return result;
    }

    private static String step3(String new_id) {
        String result = "";

        for (int i = 0; i < new_id.length(); i++) {
            if ((new_id.charAt(i) + "").equals(".")){
                if (i+1 < new_id.length() && (new_id.charAt(i+1) + "").equals(".")){
                    continue;
                }
            }
            result += new_id.charAt(i) + "";
        }
        return result;
    }

    private static String step4(String new_id) {
        if(new_id.startsWith("."))
            new_id = new_id.substring(1);
        if(new_id.endsWith("."))
            new_id = new_id.substring(0,new_id.length()-1);
        return new_id;
    }

    private static String step5(String new_id) {
        if(new_id.isEmpty())
            new_id += "a";
        return new_id;
    }

    private static String step6(String new_id) {
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if ((new_id.charAt(14) + "").equals("."))
                new_id = new_id.substring(0,14);
        }
        return new_id;
    }

    private static String step7(String new_id) {
        if (new_id.length() <= 2){
            while(new_id.length() < 3){
                new_id += new_id.charAt(new_id.length()-1) + "";
            }
        }
        return new_id;
    }
}
