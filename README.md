<p align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="docs/brand/svg/etulang-lexer-logo-on-dark.svg">
    <img src="docs/brand/svg/etulang-lexer-logo-on-light.svg" alt="ETULang Lexical Analyzer" width="260">
  </picture>
</p>

<h1 align="center">Read ETULang source. Print every token.</h1>

<p align="center">
  Archived homework for a Programming Languages course, 2021.<br>
  <b>One Java file. Nine reserved words. One token per line of output.</b>
</p>

<p align="center">
  <img alt="Status: archived" src="https://img.shields.io/badge/status-archived-5B2A36?style=flat-square">
  <a href="LICENSE"><img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-3b82f6?style=flat-square"></a>
  <img alt="Java 11 or newer" src="https://img.shields.io/badge/Java-11%20or%20newer-ED8B00?style=flat-square&logo=openjdk&logoColor=white">
  <img alt="Nine reserved words" src="https://img.shields.io/badge/reserved%20words-9-1E2A38?style=flat-square">
  <a href="https://github.com/mertkayacs/ETULang-Lexical-Analyzer"><img alt="GitHub stars" src="https://img.shields.io/github/stars/mertkayacs/ETULang-Lexical-Analyzer?style=flat-square&logo=github&color=C4A772"></a>
</p>

<p align="center">
  <a href="#quick-start"><img alt="Run it" src="https://img.shields.io/badge/Run%20it-5B2A36?style=for-the-badge&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCIgd2lkdGg9IjI0IiBoZWlnaHQ9IjI0Ij48ZyBmaWxsPSJub25lIiBzdHJva2U9IiNmZmZmZmYiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIyIj48cGF0aCBkPSJNMTIgMTloOCIvPjxwYXRoIGQ9Im00IDE3IDYtNi02LTYiLz48L2c%2BPC9zdmc%2B&logoColor=white"></a>
  <a href="hw1_mert_kaya.java"><img alt="Source" src="https://img.shields.io/badge/Source-1E2A38?style=for-the-badge&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCIgd2lkdGg9IjI0IiBoZWlnaHQ9IjI0Ij48ZyBmaWxsPSJub25lIiBzdHJva2U9IiNmZmZmZmYiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIyIj48cGF0aCBkPSJtMTYgMTggNi02LTYtNiIvPjxwYXRoIGQ9Im04IDYtNiA2IDYgNiIvPjwvZz48L3N2Zz4%3D&logoColor=white"></a>
  <a href="https://mertkayacs.com/?utm_source=github&utm_medium=readme&utm_campaign=ETULang-Lexical-Analyzer-repo&utm_content=portfolio-badge"><img alt="Portfolio" src="https://img.shields.io/badge/Portfolio-1E2A38?style=for-the-badge&logo=data%3Aimage%2Fsvg%2Bxml%3Bbase64%2CPHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCIgd2lkdGg9IjI0IiBoZWlnaHQ9IjI0Ij48ZyBmaWxsPSJub25lIiBzdHJva2U9IiNmZmZmZmYiIHN0cm9rZS1saW5lY2FwPSJyb3VuZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLXdpZHRoPSIyIj48Y2lyY2xlIGN4PSIxMiIgY3k9IjEyIiByPSIxMCIvPjxwYXRoIGQ9Ik0xMiAyYTE0LjUgMTQuNSAwIDAgMCAwIDIwYTE0LjUgMTQuNSAwIDAgMCAwLTIwTTIgMTJoMjAiLz48L2c%2BPC9zdmc%2B&logoColor=white"></a>
</p>

<p align="center">
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="docs/assets/readme/hero-dark.webp">
    <img src="docs/assets/readme/hero-light.webp" alt="Terminal showing the token lines the ETULang analyzer writes for a small sample program" width="960">
  </picture>
</p>

ETULang Lexical Analyzer is a hand-written lexer for ETULang, a small teaching language from a Programming Languages homework. It reads a program from a file with the .ETU extension and writes one line per token to an output file. Reserved words, identifiers, integer literals, operators and punctuation each get their own token name. The whole analyzer is a single Java file of about 450 lines.

---

## Why ETULang Lexical Analyzer

The lexer stays small and each rule is easy to find in the source.

|  |  |
|---|---|
| <img src="docs/assets/readme/icons/file-input.svg" width="18" height="18" alt=""> **Files in, tokens out** | Pass an .ETU file and an output file name. Each output line reads `Next token is RES_WORD` followed by the lexeme. |
| <img src="docs/assets/readme/icons/list-checks.svg" width="18" height="18" alt=""> **Nine reserved words** | program, begin, end, if, then, else, while, integer and var are matched without regard to case. |
| <img src="docs/assets/readme/icons/message-square-off.svg" width="18" height="18" alt=""> **Comments are skipped** | A percent sign toggles comment mode, and everything inside a comment is ignored. |

## A quick tour

<table>
  <tr>
    <td width="50%" valign="top">
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="docs/assets/readme/tour/input-dark.webp">
        <img src="docs/assets/readme/tour/input-light.webp" alt="Code card showing the six lines of the sample ETULang program">
      </picture>
      <h3>Sample program</h3>
      A small ETULang program with a variable declaration, an assignment, an if and a comment between percent signs.
    </td>
    <td width="50%" valign="top">
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="docs/assets/readme/tour/assign-dark.webp">
        <img src="docs/assets/readme/tour/assign-light.webp" alt="Code card showing how hw1_mert_kaya.java tells the assignment token from a colon">
      </picture>
      <h3>Assignment token</h3>
      A colon followed by an equals sign becomes the assignment token. A lone colon becomes a COLON token.
    </td>
  </tr>
  <tr>
    <td width="50%" valign="top">
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="docs/assets/readme/tour/error-dark.webp">
        <img src="docs/assets/readme/tour/error-light.webp" alt="Terminal showing token lines ending in an error message for the input 12abc">
      </picture>
      <h3>Error case</h3>
      A number followed by letters ends the analysis with an error line.
    </td>
    <td width="50%" valign="top">
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="docs/assets/readme/tour/source-dark.webp">
        <img src="docs/assets/readme/tour/source-light.webp" alt="Code card showing the reserved word checks in hw1_mert_kaya.java">
      </picture>
      <h3>Reserved words</h3>
      The first reserved-word checks in hw1_mert_kaya.java, matched without regard to case.
    </td>
  </tr>
</table>

<p align="center"><sub>The sample programs were written for this tour. The terminal card shows real output of the analyzer, and the code cards show files as they are in the repository.</sub></p>

## Features

**Tokens**

- RES_WORD, identifier and INT_LIT.
- ADD, SUBT, MULT and DIV, plus ASSIGNM for :=.
- COLON, SEMICOLON, COMMA, LPARANT and RPARANT.
- LESS, LESS_EQ, GREATER, GRE_EQ and NOTEQ.
- UNKNOWN for any other character.

**Checks**

- The input file name must end in .ETU, otherwise the output file says so.
- A number followed by letters is reported as an error.

## Quick start

```sh
javac hw1_mert_kaya.java
java hw1_mert_kaya program.ETU tokens.txt
```

The first argument is the input program and the second is the output file. The repository holds no sample program, so write one with the reserved words above.

### Requirements

- Java 11 or newer. The code calls `String.isBlank()`, which Java 11 added.

## FAQ

<details>
<summary><b>What is ETULang?</b></summary>

A small teaching language from the Programming Languages homework. The repository holds the lexer only and does not define the grammar.
</details>

<details>
<summary><b>Which Java version do I need?</b></summary>

Java 11 or newer, because of String.isBlank().
</details>

<details>
<summary><b>Where does the output go?</b></summary>

Into the file named by the second argument, one token per line.
</details>

If ETULang Lexical Analyzer is useful to you, a ⭐ helps other people find it.

## License

[MIT](LICENSE).

[![views](https://hits.sh/github.com/mertkayacs/ETULang-Lexical-Analyzer.svg?view=today-total&style=flat-square&label=views&color=5B2A36&labelColor=1E2A38)](https://github.com/mertkayacs/ETULang-Lexical-Analyzer)
