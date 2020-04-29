package regular_expression;

import static regular_expression.RegularExpUtil.test;
import java.util.regex.Pattern;

public class RegexModifierFlags {

    public static void main(String[] args) {
        runFlagsCaseInsensitiveExamples();
        runFlagsMultiLineExamples();
        runFlagsDotAllExamples();
        runFlagsCommentExamples();
        runFlagsUnicodeCaseExamples();
        runFlagsLiteralExamples();
        runFlagsUnixLinesExamples();
        runFlagsCanonicalEquivalenceExamples();
    }

    private static void runFlagsCaseInsensitiveExamples() {
        test("\\b[a-z]+\\b", "Stew Pasta Twinkies");
        test("\\b[a-z]+\\b", "Stew Pasta Twinkies", Pattern.CASE_INSENSITIVE);
        test("(?i)\\b[a-z]+\\b", "Stew Pasta Twinkies");
        test("[0-9]*(?i)\\b[a-z]+\\b", "Stew Pasta Twinkies");
        test("(?-i)\\b[a-z]+\\b", "Stew Pasta Twinkies");
        test("(?i)\\b[a-z]+\\b(?-i)[-][A-Z]", "Stew-A Pasta-B Twinkies-t");
    }

    private static void runFlagsMultiLineExamples() {
        test("^T.*e", "The First line\nThe SecondLine");
        test("^T.*e$", "The First line\nThe SecondLine");
        test("^T.*e$", "The First line\nThe SecondLine", Pattern.MULTILINE);
        test("(?m)^T.*e$", "The First line\nThe SecondLine");
        test("(?m)^T.*e$", "The First line\rThe SecondLine");
        test("(?m)^T.*e$", "The First line\n\rThe SecondLine");
    }

    public static void runFlagsDotAllExamples() {
        test("The.*sentence", "The is \n one sentence");
        test("The.*sentence", "The is \n one sentence", Pattern.DOTALL);
        test("The.*sentence", "The is \n one sentence", Pattern.DOTALL | Pattern.MULTILINE);
        test("^T.*e$", "The First line\nThe SecondLine", Pattern.MULTILINE | Pattern.DOTALL);
        test("^T.*e$", "The First line\nThe SecondLine", Pattern.MULTILINE);
        test("(?s)The.*sentence", "The is a\n one sentence");
    }

    private static void runFlagsCommentExamples() {
        test("\\d+ ft", "2 ft, 5 ft");
        test("\\d+ ft", "2 ft, 5 ft", Pattern.COMMENTS);
        test("\\d+\\sft", "2 ft, 5 ft", Pattern.COMMENTS);
        test("  \\d+     \\s     ft  ", "2 ft, 5 ft", Pattern.COMMENTS);
        test("\\d{2,5}[a-z]", "22a 33c");
        test("\\d{2,5}[a-z]#product code", "22a 33c");
        test("\\d{2,5}[a-z]#product code", "22a 33c#product code");
        test("\\d{2,5}[a-z]#product code", "22a 33c", Pattern.COMMENTS);
        test("\\d{2,5}[a-z]#product code\n\\s\\d{4,4}#customer id", "22a 3434 33c 6767", Pattern.COMMENTS);
        test("(?x)\\d{2,5}[a-z]#product code\n\\s\\d{4,4}#customer id", "22a 3434 33c 6767", 0);
    }

    private static void runFlagsUnicodeCaseExamples() {
        test("\u00DE", "\u00FE");
        test("\u00DE", "\u00FE", Pattern.CASE_INSENSITIVE);
        test("\u00DE", "\u00FE", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        test("(?iu)\u00DE", "\u00FE");
    }

    private static void runFlagsLiteralExamples() {
        test("[a-z]+", "test");
        test("[a-z]+", "test", Pattern.LITERAL);
        test("[a-z]+", "[a-z]+", Pattern.LITERAL);
        test(Pattern.quote("[a-z]+"), "[a-z]+");
        test("[a-z]+", "[a-Z]+", Pattern.LITERAL | Pattern.CASE_INSENSITIVE);
        test("(?i)[a-z]+", "[a-Z]+", Pattern.LITERAL);
        test("(?i)[a-z]+", "(?i)[a-z]+", Pattern.LITERAL);
    }

    private static void runFlagsUnixLinesExamples() {
        test("^T.*e", "The First line\rThe Second line\nThe third Line");
        test("^T.*e$", "The First line\rThe Second line\nThe third Line");
        test("^T.*e$", "The First line\rThe Second line\nThe third Line", Pattern.MULTILINE);
        test("^T.*e", "The First line\rThe Second line\nThe third Line", Pattern.UNIX_LINES);
        test("^T.*e$", "The First line\rThe Second line\nThe third Line", Pattern.UNIX_LINES);
        test("^T.*e$", "The First line\rThe Second line\nThe third Line", Pattern.UNIX_LINES | Pattern.MULTILINE);
        test("(?d)^T.*e$", "The First line\rThe Second line\nThe third Line", Pattern.UNIX_LINES | Pattern.MULTILINE);
    }

    private static void runFlagsCanonicalEquivalenceExamples() {
        test("\u006E\u0303", "\u00F1");
        test("\u006E\u0303", "\u00F1");
        test("\u00F1", "\u006E\u0303");
    }
}
