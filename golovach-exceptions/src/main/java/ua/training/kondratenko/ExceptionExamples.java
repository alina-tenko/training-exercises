package ua.training.kondratenko;

/**
 * Exception examples by Golovach
 * https://habr.com/en/company/golovachcourses/blog/223821/
 * https://habr.com/en/company/golovachcourses/blog/225585/
 */
public class ExceptionExamples {
}

class App1 {
    public static void main(String[] args) throws Throwable {}
}

//class App2 {
//    public static void main(String[] args) throws String {}
//}
//
//>> COMPILATION ERROR: Incompatible types: required 'java.lang.Throwable', found: 'java.lang.String'

class App3 {
    public static void main(String[] args) {
        try {
        } catch (Throwable t) {}
    }
}

//class App4 {
//    public static void main(String[] args) {
//        try {
//        } catch (String s) {}
//    }
//}
//
//>> COMPILATION ERROR: Incompatible types: required 'java.lang.Throwable', found: 'java.lang.String'

class App5 {
    public static void main(String[] args) {
        // Error - потомок Throwable
        throw new Error();
    }
}

//class App6 {
//    public static void main(String[] args) {
//        throw new String("Hello!");
//    }
//}
//
//>> COMPILATION ERROR: Incompatible types: required 'java.lang.Throwable', found: 'java.lang.String'

//class App7 {
//    public static void main(String[] args) {
//        throw null;
//    }
//}
//
//>> RUNTIME ERROR: Exception in thread "main" java.lang.NullPointerException

class App8 {
    public static void main(String[] args) {
        Error ref = new Error(); // создаем экземпляр
        throw ref;               // "бросаем" его
    }
}
//>> RUNTIME ERROR: Exception in thread "main" java.lang.Error

class App9 {
    public static void main(String[] args) {
        f(null);
    }
    public static void f(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            f(npe);
        }
    }
}
//>> RUNTIME ERROR: Exception in thread "main" java.lang.StackOverflowError

class App10 {
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
}
//>> RUNTIME ERROR: Exception in thread "main" java.lang.Error
//        >> sout

//class App11 {
//    public static double sqr(double arg) {
//        if (System.currentTimeMillis() % 2 == 0) {
//            return arg * arg; // если currentTimeMillis() - четное число, то все ОК
//        }
//        // а если нечетное, что нам возвращать?
//    }
//}
//
//>> COMPILATION ERROR: Missing return statement

class App12 {
    public static double sqr(double arg) {
        throw new RuntimeException();
    }
}
//class App13 {
//    public static double sqr(double arg) {// согласно объявлению метода ты должен вернуть double
//        long time = System.currentTimeMillis();
//        if (time % 2 == 0) {
//            return arg * arg;             // ок, вот твой double
//        } else if (time % 2 == 1) {
//            {
//                while (true) ;                 // не, я решил "повиснуть"
//            } else{
//                throw new RuntimeException(); // или бросить исключение
//            }
//        }
//    }
//}

class App14 {
    public static void main(String[] args) {
        // sqr - "сломается" (из него "выскочит" исключение),
        double d = sqr(10.0);  // выполнение метода main() прервется в этой строчке и
        // d - НИКОГДА НИЧЕГО НЕ БУДЕТ ПРИСВОЕНО!
        System.out.println(d); // и печатать нам ничего не придется!
    }
    public static double sqr(double arg) {
        throw new RuntimeException(); // "бросаем" исключение
    }
}
//>> RUNTIME ERROR: Exception in thread "main" java.lang.RuntimeException

class App15{
    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }
}

class App16 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out");  //вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // вернулись
    } // выходим из текущего фрейма, кончились инструкции

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.RETURN");
            return; // выходим из текущего фрейма по 'return'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСКАЕМ
    }
}
//        >> #1.in
//        >> .   #2.in
//        >> .   .   #3.in
//        >> .   .   .   #4.in
//        >> .   .   .   #4.RETURN
//        >> .   .   #3.out
//        >> .   #2.out
//        >> #1.out

class App17 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // ПРОПУСТИЛИ!
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}
//        >> #1.in
//        >> .   #2.in
//        >> .   .   #3.in
//        >> .   .   .   #4.in
//        >> .   .   .   #4.THROW
//        >> RUNTIME ERROR: Exception in thread "main" java.lang.Error

class App18 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        try {
            f(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println("#1.CATCH");  // и работаем
        }
        System.err.println("#1.out");  // работаем дальше
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}
//        >> #1.in
//        >> .   #2.in
//        >> .   .   #3.in
//        >> .   .   .   #4.in
//        >> .   .   .   #4.THROW
//        >> #1.CATCH
//        >> #1.out

class App19 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        try {
            g(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   #2.CATCH");  // и работаем
        }
        System.err.println(".   #2.out");  // работаем дальше
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        h(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}
//        >> #1.in
//        >> .   #2.in
//        >> .   .   #3.in
//        >> .   .   .   #4.in
//        >> .   .   .   #4.THROW
//        >> .   #2.CATCH
//        >> .   #2.out
//        >> #1.out

class App20 {
    public static void main(String[] args) {
        System.err.println("#1.in");
        f(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println("#1.out"); // вернулись и работаем
    }

    public static void f() {
        System.err.println(".   #2.in");
        g(); // создаем фрейм, помещаем в стек, передаем в него управление
        System.err.println(".   #2.out"); // вернулись и работаем
    }

    public static void g() {
        System.err.println(".   .   #3.in");
        try {
            h(); // создаем фрейм, помещаем в стек, передаем в него управление
        } catch (Error e) { // "перехватили" "летящее" исключение
            System.err.println(".   .   #3.CATCH");  // и работаем
        }
        System.err.println(".   .   #3.out");  // работаем дальше
    }

    public static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
        }
        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
    }
}
//        >> #1.in
//        >> .   #2.in
//        >> .   .   #3.in
//        >> .   .   .   #4.in
//        >> .   .   .   #4.THROW
//        >> .   .   #3.CATCH
//        >> .   .   #3.out
//        >> .   #2.out
//        >> #1.out

class App21 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {throw new RuntimeException();}
            System.err.print(" 1");
        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
            System.err.print(" 2");
        }
        System.err.println(" 3");
    }
}
//>> 0 2 3

class App22 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("Это RuntimeException на самом деле!!!");
            } else {
                System.err.print("В каком смысле не RuntimeException???");
            }
        }
    }
}
//>> Это RuntimeException на самом деле!!!

