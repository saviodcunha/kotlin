// EXPECTED_REACHABLE_NODES: 1112
package foo

fun box(): String {
    var s = "abc"
    assertEquals("ABC", (String::toUpperCase)(s))

    return "OK"
}
