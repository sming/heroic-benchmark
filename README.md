# heroic-benchmark
Small microbenchmarking repo based upon JMH benchmarking library

***Really important Coding / Maintentenance Note***

- When using [JMH](https://hg.openjdk.java.net/code-tools/jmh) (or any 
other annotation-based lib), ***do not trust*** IntelliJ’s 
`Build Project`. It will not always rebuild the auto-generated classes produced by said lib.
  - → Use `Rebuild Project` when changing annotations.


## List of Benchmarked Functionality

1. Simple Series arithmetic

