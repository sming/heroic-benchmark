# heroic-benchmark
Small microbenchmarking repo based upon JMH benchmarking library

***Really important Coding / Maintentenance Note***

- When using [JMH](https://hg.openjdk.java.net/code-tools/jmh) (or any 
other annotation-based lib), ***do not trust*** IntelliJ’s 
`Build Project`. It will not always rebuild the auto-generated classes produced by said lib.
  - → Use `Rebuild Project` when changing annotations.


## List of Benchmarked Functionality

1. Simple Series arithmetic

## Running the Benchmarks

1. currently there's only `BenchmarkRunner.main` as an entrypoint so
simply run that
1. supply `devMode` as a parameter when coding this repo, so that you
can see if your changes work, without having to wait a long time for
benchmarking to finish. 

