(ns mei.collections)

; Here, we're work a little bit with collections, i.e. maps, arrays and functions related to them.

; Let's suppose we need to recalculate the amount of every loan charge and apply another interest rate of 16%.
; Thus, let's create a function that receives a charge as parameter and apply the 16% interest rate for its amount.
; -- HINT take a look at 'update' clojure function
(defn update-amount [charge]
  ; (...)
  )

; Now that we've already created the function to update the charge amount of a single charge, what about doing that for
; every loan charge from the loan we've created on the other namespace?
; -- HINT take a look at 'map' function
(def updated-charges )

; Good. Now we need to include the new charges on the loan map, so what about doing so?
; -- we can use the `assoc` function here too!
(def updated-loan )

; Yeah, that's it! Now, what if we want to calculate the sum of ALL loan charges amount?
; -- HINT take a look at 'reduce' function
(def amount-sum )

; This doesn't make much sense on our context, but good job! :heheboi:
; Now, since a customer may have more than one loan, let's create a function that receives some loan parameters and
; creates a new loan! Remember that we've already created a function to create a charge from some fields, so you may
; also use it here to create the new loan charges.
; Also, since we forgot to add before, include another field on the loan called `type` and it can be :personal or
; :credit-card.
(defn function_name_using_the_previous_naming_pattern_for_fields_to_object_ish [])

; Now, using the function above, create some loans and store them in a `loans` symbol, just to facilitate our work
; lately. For the `type` key, try to add different types for the loan, so we can filter them lately!
(...)

; Now, another important field on the loans that we forgot is the `status`. It says in which foot (em que pé :heheboi)
; the loan is. For example, when we issue a loan, its status is 'current' because the loan is still alive.
; Now, since there is no payment for the loans, add this field to all of them with the value :current.
(def current-loans ...)

; Good! Now, as said before, let's try to filter the loans based on the type. We want to get only the personal loans.
; How can we do that?
(def personal-loan )

; To finish playing with this step, imagine the customer received his 13º payment and chose to PAY all of his
; PERSONAL LOANS. Then, when a customer pays a loan, its STATUS is _'paid'_. You know what to do, right?
(...)
