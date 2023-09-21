(ns mei.operations)

; The idea is to train the basic clojure operations using our intern glossary. That means we're going to do the basics,
; e.g. "sum two numbers", but using the terms we're usually using in our meetings and ceremonies. If there is any
; question about what each term means, you can reach the previous shared glossary or contact your buddy to do so!
; That's all, folks! Good studying!

; The principal is the amount the customer is requesting for the loan. So a principal of $300 is "the amount the
; customer asked us".
(def principal 300M)

; talking about amortization, we're talking about removing some value from something. In the function below, the
; "amortization" refers to the principal (take a look on the glossary) of the loan, so the amortization is the value
; we're going to subtract from the principal.
; Thus, complete the function below to amortize the 'amortization' value from the 'principal'
(defn amortize [amortization]
  ;(...)
  )

; Now, amortize 20M from the principal using the created function above.
(...)

; We also have an interest rate that is the rate we're going to consider when calculating the interest at each due date,
; i.e. the 'dia do vencimento' of each charge.
; Create an interest rate of 10%.
(def interest-rate )

; Now, considering the principal and the interest rate above, calculate the interest of the loan at the due date
(def interest-at-due-date )

; Great! Now, having the principal and the interest, calculate the present value of the loan.
(def present-value )

; Good job! Now let's include all this information in a single structure, called 'map'.
; The map has fields and each field is composed by a key and a value. For example, if I create a map representing a
; person, I'd do
;
; {:name   "Marinho"
;  :age    24
;  :zodiac "Pisces"}
;
; Each field represents different information and can be of any type.
; If I want to get the value of some field, I just need to search for its key on the map. To do so, we may use two
; different ways: `(key map)` or (get map key). For example, to get the name of the previous map, we'd do
; `(:name person)` or `(get person :name)`.
; Now, create a map representing a loan with the previous information (principal, interest-rate and present-value).
(def loan )

; With the created loan, return the loan principal using one of the above ways.
(...)

; A loan isn't exactly what we've done before, but let's walk step by step.

; Now that we've already understood the basic concepts, let's try to create a charge (see the glossary here too).
; Let's assume a charge having the following fields: index, due date, amount and status. For all these fields, we have
; a description in the glossary, so don't forget to take a look over there!
; Now, create a charge having these fields.
(def charge )

; A loan may have multiple charges, so it'd be good to create many of them. However, instead of creating multiple `defs`
; with a different charge each, what about creating a function receiving the fields above and returning a map
; representing a charge? :interesting:
; We have a code style/rule/something to create functions that CREATE stuff. For example, in this case, we're receiving
; many fields and creating a charge FROM these fields. So, we're going from fields to charge. In other words-ish,
; fields->charge. However, 'fields' is too generic, so we can just remove it and use `->charge` only.
(defn ->charge [])

; Then, create n charges using the function above. Don't forget we're creating an array, so we may use the function for
; each array element.
(def charges )

; Now that we have the charges, what about associate a new key on our `loan` with the charges?
(def loan-with-charges )

; Good! Now we have a loan-ish! Tell the squad lead you want a Big Xande, or Chandon for intimates, to celebrate that.
