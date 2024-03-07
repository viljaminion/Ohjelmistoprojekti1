## REST-dokumentaatio

Endpointtien autentikointia ei ole vielä tässä vaiheessa määritelty.

Alla olevat endpointit ovat suppea versio REST-dokumentaatiosta.


**EventControllerin endpointit selaimessa:**

- Tapahtumalistaus: "/eventlist"
- Tapahtuman lisäys: "/events/add"
- Tapahtuman tallennus: "/events/save"
- Tapahtuman poisto: "/events/delete/{id}"
- Tapahtuman muokkaus: "/events/edit/{id}"

**EventRestControllerin endpointit (Postman)**

- Kaikki tiedot JSON-muodossa: <span style="color:green">GET</span> "/events"
- Tietyn tapahtuman tiedot ID:n avulla: <span style="color:green">GET</span> "/event/{id}"
- Tapahtuman lisäys Postmanilla: <span style="color:yellow">POST</span> "/event"
- Tapahtuman poisto Postmanilla: <span style="color:red">DELETE</span> "/event/{id}"


**TicketTypeControllerin endpointit selaimessa:**

- Listanäkymä: "/tickettypelist"
- Lisäys: "/tickettypes/add"
- Tallennus: "/tickettypes/save"
- Poisto: "tickettypes/delete/{id}"
- Muokkaus: "/editTicketType/{id}"

**TicketTypeRestControllerin endpointit (Postman):**

- Kaikki tiedot JSON-muodossa:
<span style="color:green">GET</span> "/tickettypes"
- Tietyn lipputyypin tiedot ID:n avulla:
<span style="color:green">GET</span> "/tickettype/{id}"
- Lipputyypin lisäys Postmanilla:
<span style="color:yellow">POST</span> "/addtickettype"
- Lipputyypin poisto Postmanilla:
<span style="color:red">DELETE</span> "/tickettype/delete/{id}"


**TransactionControllerin endpointit selaimessa:**

- Ostotapahtumalistaus: "/transactionlist"
- Ostotapahtuman lisäys: "/transactions/add"
- Ostotapahtuman tallennus: "/transactions/save"
- Ostoapahtuman poisto: "/transactions/delete/{id}"
- Ostotapahtuman muokkaus: "/editTransaction/{id}"

**TransactionRestControllerin endpointit (Postman)**

- Kaikki tiedot JSON-muodossa: <span style="color:green">GET</span> "/transactions"
- Tietyn ostotapahtuman tiedot ID:n avulla: <span style="color:green">GET</span> "/transaction/{id}"
- Ostoapahtuman lisäys Postmanilla: <span style="color:yellow">POST</span> "/etransaction"
- Ostotapahtuman poisto Postmanilla: <span style="color:red">DELETE</span> "/eventtransaction/{id}"

**SellerControllerin endpointit selaimessa:**

- Lista myyjistä: "/sellerlist"
- Myyjän lisäys: "/sellers/add"
- Myyjän tietojen tallennus: "/sellers/save"
- Myyjän tietojen muokkaaminen: "sellers/edit/{id}"
- Myyjän tietojen poistaminen: "sellers/delete/{id}

**SellerRestControllerin endpointit (Postman)**

- Kaikki tiedot JSON-muodossa: <span style="color:green">GET</span> "/sellers"
- Tietyn myyjän tiedot ID:n avulla: <span style="color:green">GET</span> "/seller/{id}"
- Myyjän tietojen lisääminen Postmanilla: <span style="color:yellow">POST</span> "/seller"
- Myyjän poisto Postmanilla: <span style="color:red">DELETE</span> "/seller/{id}"

