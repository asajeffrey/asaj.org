# 30 YEARS OF MONADS

Speaker notes for Alan Jeffrey, Chicago Papers We Love, 2018-03-10.

- **Comprehending Monads** Wadler (1990) in *Proc. ACM LISP and Functional Prog.* and (1992) in *Math Struct. CS*.
- **Computational lambda-calculus and monads** Moggi (1989) in *Proc. IEEE Logic in CS*.

Papers at the boundary of PL and API design.

## Introduction

### Elevator pitch

*Side-effects can be an API, not a language feature*

### Contribution

Pretty picture:

```
  +--Ecosystem-----------------------------------+
  |                                              |
  | PROG   STD   USER                            |
  | LANG   LIB   LIBS                            |
  |                                              |
  |   FFI    BUILD    PKG    DOCS   TESTS   ...  |
  |           SYS     MGR                        |
  |                                              |
  +----------------------------------------------+
```

Choice about where features live, e.g. C:

- shared-memory concurrency: PL
- condvars, mutexes: stdlib
- other concurrency controls: user libs

So *where do side-effects live*?

- Before: obvious, they're in the PL!
- After: part of ecosystem design.

Contributions of Wadler (1990):

- Move side-effects from PL to libraries
- API for side-effects
- Lots of examples (nondeterminism, state, exceptions...)

Based on Moggi (1989):

- Computational λ-calculus
- Semantics
- Connection to category theory

### Trade-off

Pure languages are nice:

- easier to understand,
- no hidden wiring (global vars, dependency injection etc.),
- support nice optimizations, *but*

impure APIs are nice too:

- hidden wiring is not in the API description,
- interaction (e.g. other langs, processes, networks, user, etc.),
- effeciency (e.g. in-place update, less runtime system, etc.).

Can we move side-effects out of the lang and into libs?

### Examples

*The awkward squad* (Simon PJ).

Random-number generation:

```haskell
x <- rng(); y <- rng(); return (x-y)
```

I/O:
```haskell
x <- readln(); println("Hello" + x); ...
```

Exceptions:
```haskell
x <- parseInt("37"); y <- parseInt("⌣"); ...
```

etc.

Is there an API that captures these examples (and hopefully others)?

## Ideas

### Idea 1: thunks

Introduce effectful *thunks* (aka delayed computations, a lot like futures, generators, etc.).

Think of *T*(*A*) as the type of effectful thunks which have effects, and produce *A*s.

(Types might be dynamic or static, e.g. you can do this in JS!)

- *A* → *B* is the type of pure functions from *A* to *B*.
- *A* → *T*(*B*) is the type of pure functions from *A* to effectful thunks that produce *B*s.

This separates out *function application* from *forcing* the tunk (getting it to produce values).

For example `x <- rng()` is two operations:

- *apply* `rng` to `()`, getting a thunked integer, and
- *force* the thunk, and binding it to `x`, an integer.

### Idea 2: binding is an API not a language feature

What is written `x <- M; N` can be implemented as an API:

- Haskell: `M >>= (λ x . N)`
- JS: `M.flatMap(x => N)`
- Rust: `M.flat_map(|x| N)`
- ...

The signature of the API:

- `>>=` has type *T*(*A*) → (*A* → *T*(*B*)) → *T*(B)*
- `return` has type *A* → *T*(*A*)

e.g.
```haskell
x <- rng(); y <- rng(); return (x-y)
```
is implemented as:
```haskell
rng() >>= (λ x . rng() >>= (λ y . return (x-y)))
```

### Idea 3: syntax

Helps with ergonomics.

- Wadler uses list comprehensions,
- Moggi uses computational λ-calculus,
- Haskell uses do-notation,
- Most other languages: you're out of luck!

Language ergonomics is tricky (and out of scope for these papers).

### Idea 4: lots of different monads

There isn't just one *T*, there's lots!

- `RNG(A)` for thunks that (when forced) randomly genenerate an `A`,
- `IO(A)` for thunks that (when forced) do some I/O and return an `A`,
- `Maybe(A)` for thunks that (when forced) might return an `A` or might not,
- ...

In languages like Haskell, you can even parameterize over monads,
e.g. `mapM` has type [*A*] → (*A* → *T*(*B*)) → *T*[*B*] for any
types *A* and *B*, and for any monad *T*.

## In the last 30 years

### Impact

Haskell! Language design generally! Fancy types! Papers! Implementations! T-shirts! Memes!

### Combining effects

Problem: given monads *T* and *U* how do I combine them?

Example: a program that randomly does IO.

Solutions: monad transformers, the monad stack, effect algebras etc.

### Weaker APIs

Problem: what if I can't implement that API?

Example: dataflow programs with fixed flow graph.

Solutions: applicative functors, arrows, etc.

### Lessons learned (by me at least)

- The boundaries of a s/w ecosystem are not fixed.
- API design is hard.
- Practical impact can come from unexpected places. (algebraic topology? really?)
- Insight from people with different backgrounds is surprisingly effective.
