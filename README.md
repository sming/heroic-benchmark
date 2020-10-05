# heroic-benchmark
Small microbenchmarking repo based upon JMH benchmarking library

## *Really* important Coding / Maintentenance Note

I (peterk) have wasted approx 6 hours, whilst questioning my own sanity, because I forgot that
 JMH uses a preprocessor to do it's thang. This means that whenever you make *any* kind of JMH-y
  change e.g. adding/removing/changing an annotation, you ***MUST*** do a *Rebuild Project* in
   IntelliJ. Grr. 
   
