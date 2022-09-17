# design-pattern

## 1. 생성 패턴(Creational Pattern)

### [Factory Method(팩터리 메서드)](src/creational/FactoryMethod.java)

> 상위 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴을 의미한다. 하위 클래스가 어떤 객체를 생성할지 선택한다.   
> (이름으로 인해 객체를 생성하는 메서드를 Factory Method라 오해하는 개발자가 많이 있다.)


### [Abstract Factory(추상 팩터리)](src/creational/AbstractFactory.java)

> 구체적인 클래스에 의존하지 않고 서로 연관/의존하는 객체들의 그룹으로 생성하여 추상적으로 표현한다.
> 이를 통해 연관된 서브 클래스를 묶어 한번에 교체가 가능하다. 이렇게 일관성은 늘어나지만, 반대로 확장성은 매우 떨어진다.
> 메서드 하나를 추가하기 위해서는 이미 만들어진 클래스에서 전부 구현해야 한다. (default keyword가 존재하지만, 해당 기능을 각 클래스에서 구현해야 하는것은 변하지 않는다.)