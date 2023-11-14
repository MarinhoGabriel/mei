(ns mei.collections
  (:require [mei.operations :as operations]))

; Here, we're work a little bit with collections, i.e. maps, arrays and functions related to them.

; Let's suppose we need to recalculate the amount of every loan charge and apply another interest rate of 16%.
; Thus, let's create a function that receives a charge as parameter and apply the 16% interest rate for its amount.
; -- HINT take a look at 'update' clojure function
(defn update-amount [charge]
  (update charge :amount #(* % 1.16)))

; Using thread-last macro, do the same thing as above.
(defn update-amount-thread-last [charge]
  (->> charge
       (update :amount #(* % 1.16))))

; Now that we've already created the function to update the charge amount of a single charge, what about doing that for
; every loan charge from the loan we've created on the other namespace?
; -- HINT take a look at 'map' function
(def updated-charge
  (map update-amount operations/charges))

(println updated-charge)

; Good. Now we need to include the new charges on the loan map, so what about doing so?
; -- we can use the `assoc` function here too!
(def updated-loan
  (assoc operations/loan :charges updated-charge))

(println updated-loan)

; Yeah, that's it! Now, what if we want to calculate the sum of ALL loan charges amount?
; -- HINT take a look at 'reduce' function
(def amount-sum
  (reduce + (map :amount updated-charge)))

(println amount-sum)

; Using thread-last macro, do the same thing as above.
(def amount-sum-thread-last
  (->> updated-charge
       (map :amount)
       (reduce +)))

(println amount-sum-thread-last)

; This doesn't make much sense on our context, but good job! :heheboi:
; Now, since a customer may have more than one loan, let's create a function that receives some loan parameters and
; creates a new loan! Remember that we've already created a function to create a charge from some fields, so you may
; also use it here to create the new loan charges.
; Also, since we forgot to add before, include another field on the loan called `type` and it can be :personal or
; :credit-card.
(defn ->loan [principal interest-rate present-value type charges]
  {:principal principal
   :interest-rate interest-rate
   :present-value present-value
   :type type
   :charges charges})

; Now, using the function above, create some loans and store them in a `loans` symbol, just to facilitate our work
; lately. For the `type` key, try to add different types for the loan, so we can filter them lately!
(def loans
  [(->loan 100M 0.1M 110M :personal operations/charges)
   (->loan 200M 0.2M 220M :credit-card operations/charges)
   (->loan 300M 0.3M 330M :personal operations/charges)
   (->loan 400M 0.4M 440M :credit-card operations/charges)
   (->loan 500M 0.5M 550M :personal operations/charges)])

; Now, another important field on the loans that we forgot is the `status`. It says in which foot (em que pé :heheboi)
; the loan is. For example, when we issue a loan, its status is 'current' because the loan is still alive.
; Now, since there is no payment for the loans, add this field to all of them with the value :current.

(def current-loans (map #(assoc % :status :current) loans))

(println current-loans)

; Using thread-last macro, do the same thing as above.
(def current-loans-thread-last
  (->> loans
       (map (fn [loan]
       (assoc loan :status :current)))))

(println current-loans-thread-last)

; Good! Now, as said before, let's try to filter the loans based on the type. We want to get only the personal loans.
; How can we do that?
(def personal-loan (filter #(= (:type %) :personal) current-loans))
(println personal-loan)

; Using thread-last macro, do the same thing as above.
(def personal-loan-thread-last
  (->> current-loans
       (filter #(= (:type %) :personal))))

(println personal-loan-thread-last)

; To finish playing with this step, imagine the customer received his 13º payment and chose to PAY all of his
; PERSONAL LOANS. Then, when a customer pays a loan, its STATUS is _'paid'_. You know what to do, right?
(def paid-loans (map #(assoc % :status :paid) personal-loan))
(println paid-loans)

; Using thread-last macro, do the same thing as above.
(def paid-loans-thread-last
  (->> personal-loan
       (map #(assoc % :status :paid))))

(println paid-loans-thread-last)
