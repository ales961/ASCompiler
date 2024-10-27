function fib(): i32 {
    var a = 0, b = 1;
    var n = 5;

    if (n > 0) {
        while (n != 0) {
            n = n - 1;
            let t = a + b;
            a = b;
            b = t;
        }
    }
    return a;
}