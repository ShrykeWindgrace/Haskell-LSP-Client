# Haskell LSP Client

## Haskell part

The simplest way to install all required tools is to grab a copy of https://www.haskell.org/ghcup/ 

and then install `ghc` and `haskell-language-server`. `ghcup tui` is useful to oversee what tools you can install.

In my case that's `ghc-9.6.4` and `haskell-language-server-2.7.0.0`

The file to play with:
```haskell
import Data.Char
-- import D

main :: IO ()
main = do
    putStrLn $ fmap toUpper $ fmap toLower "hi there"
    print A

data Test = A | B | C deriving (Eq, Show)

data N = N Int
```
