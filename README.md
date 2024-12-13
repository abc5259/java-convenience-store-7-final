# java-convenience-store-precourse

## 기능 요구 사항

- [ ] 환영 인사를 출력한다.
- [x] 상품과 프로모션을 초기화한다.
- [ ] 상품명, 가격, 프로모션이름, 재고를 출력한다.
- [ ] 구매할 상품명과 수량을 입력받는다.
    - [ ] 예외1. 해당하는 상품명이 없는경우
        - [ERROR] 존재하지않는상품입니다. 다시입력해 주세요.
    - [ ] 예외2. 수량이 0개 이하인 경우
        - [ERROR] 잘못된입력입니다. 다시입력해주세요.
    - [ ] 예외3. 구매수량이 재고수량을 초과한경우
        - [ERROR] 재고수량을초과하여구매할수없습니다. 다시입력해주세요.
    - [ ] 예외4. 기타 잘못된 입력의 경우
        - [ERROR] 잘못된입력입니다. 다시입력해주세요.
    - [ ] 예외5. 구매할 수량과 상품 형식이 잘못된 경우
        - [ERROR] 올바르지않은형식으로입력했습니다. 다시입력해 주세요.
- [ ] 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져왔는지 계산한다.
    - [ ] 고객에게 안내 메시지를 출력한다.
    - [ ] Y: 증정 받을수 있는 상품을 추가한다.
    - [ ] N: 증정 받을수 있는 상품을 추가하지 않는다.
- [ ] 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택없이 결제 해야 하는 경우 그 개수를 계산한다.
    - [ ] 고객에게 안내 메시지를 출력한다.
    - [ ] Y: 일부 수량에 대해 정가로 결제한다.
    - [ ] N: 정가로 결제해야 하는 수량만큼 제외한 후 결제를 진행한다
- [ ] 멤버십 할인 적용 여부를 입력받는다.
    - [ ] Y: 멤버십 할인을 적용한다.
    - [ ] N: 멤버십 할인을 적용하지 않는다.
- [ ] 영수증을 출력한다.
    - [ ] 구매상품내역
    - [ ] 증정 상품 내역
    - [ ] 총 구매액
    - [ ] 행사 할인금액
    - [ ] 멤버십 할인금액
    - [ ] 최종 결제 금액
- [ ] 추가 구매 여부를 입력받는다. 