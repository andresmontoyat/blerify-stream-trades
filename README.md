# blerify-stream-trades

## How to test the websocket
1. Open the trades.html inside the your default browser.
2. Click over "connect button"
3. Send payload:

```
{
  "e": "trade",
  "E": 123456789,
  "s": "BNBBTC",
  "t": 12345,
  "p": "0.001",
  "q": "100",
  "b": 88,
  "a": 50,
  "T": 123456785,
  "m": true,
  "M": true
}
```