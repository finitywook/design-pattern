# design-pattern

## 1. 생성 패턴(Creational Pattern)

### [Factory Method(팩터리 메서드)](src/creational/FactoryMethod.java)

> 상위 클래스에 알려지지 않은 구체 클래스를 생성하는 패턴을 의미한다. 하위 클래스가 어떤 객체를 생성할지 선택한다.   
> (이름으로 인해 객체를 생성하는 메서드를 Factory Method라 오해하는 개발자가 많이 있다.)

### [Abstract Factory(추상 팩터리)](src/creational/AbstractFactory.java)

> 구체적인 클래스에 의존하지 않고 서로 연관/의존하는 객체들의 그룹으로 생성하여 추상적으로 표현한다.
> 이를 통해 연관된 서브 클래스를 묶어 한번에 교체가 가능하다. 이렇게 일관성은 늘어나지만, 반대로 확장성은 매우 떨어진다.
> 메서드 하나를 추가하기 위해서는 이미 만들어진 클래스에서 전부 구현해야 한다. (default keyword가 존재하지만, 해당 기능을 각 클래스에서 구현해야 하는것은 변하지 않는다.)
 
### [Builder(빌더)](src/creational/Builder.java)

> 복합 객체의 생성 과정과 표현 과정을 분리하여 동일한 생성 절차에서 서로 다른 표현 결과를 얻어 낼 수 있게 하는 패턴이다. 
> 생성자가 길어지면 타입과 순서 관리가 힘들어지고, 오류 발생 확률이 높아진다. 이러한 문제를 해결하기 위하여 나온 패턴이다.  
> (디렉터를 통해 클라이언트 코드를 더 짧게 유지할 수 있다.)

### [Prototype(프로토타입)](src/creational/Prototype.java)

> 객체를 생성하는데 비용이 많이 들고, 비슷한 객체가 이미 존재할 때 사용하는 패턴이다.
> 생성할 객체들이 프로토타입인 인스턴스를 통해 결정되도록 하고 인스턴스는 새 객체를 만들기 위해 자기 자신을 복제한다.

### [Singleton(싱글톤)](src/creational/Singleton.java)

> 객체를 단 하나만 생성하여 어디서든 같은 객체를 사용한다. 객체가 단 하나이기에 메모리 관점에서 유리하다.  
> 단, 싱글톤으로 생성한 객체는 stateless를 유지해야 한다. 여러 쓰레드에서 접근 시 동시성 문제가 발생할 수 있다.

## 2. 구조 패턴(Structural Pattern)

### [Adapter(어댑터)](src/structural/Adapter.java)

> 클래스들의 호환성을 맞춰주는 패턴이다. 기존의 클래스를 사용하고 싶지만 인터페이스가 일치하지 않을 경우에도 동작하도록 만들어주는 패턴이다.
> 향후 클래스가 변경되더라도, 어댑터에 의해 캡슐화 되어있기 때문에 클라이언트는 바뀐 내용을 알 필요가 없다.
 
### [Bridge(브리지)](src/structural/Bridge.java)

> 구현부에서 추상층을 분리하여 각자 독립적으로 변형할 수 있게 하는 패턴이다. 기능과 구현을 별도 클래스에서 구현한다.

### [Composite(컴퍼지트)](src/structural/Composite.java)

> 객체들간의 관계를 트리 구조로 구성하여 부분과 전체 계층을 표현하는 패턴이다. 클라이언트가 단일 객체와 복합 객체를 모두 동일하게 다룰 수 있다.

### [Decorator(데코레이터)](src/structural/Decorator.java)

> 주어진 상황과 용도에 따라서 어떤 객체에 책임을 덧붙이는 패턴이다. 기능 확장이 필요할 때 서브클래싱 대신에 쓸 수 있는 유연한 대처 기법이다.
> 데코레이터 패턴을 사용하여 추가 기능의 조합을 동적으로 생성이 가능하다.

### [Facade(퍼사드)](src/structural/Facade.java)

> 복잡한 명령의 묶음을 표현하는 패턴이다. 리모컨으로 복잡한 명령을 간단하게 수행하듯 사용한다. 상위의 인터페이스를 구현하여 서브클래스들의 기능을 수행할 수 있다.
> 서브 클래스들 사이에 통합 인터페이스를 제공하는 Wrapper 객체가 필요하다. 또한, 좋게 작성되지 않은 API의 집합을 하나의 좋게 작성 된 API로 바꿀 수 있다.
 
### [Flyweight(플라이웨이트)](src/structural/Flyweight.java)

> 동일하거나 유사한 객체를 사용할 때 가능한 많은 데이터를 교환하여 서로 사용하도록 한다. 이렇게 하므로써 메모리 사용량을 최소화하는 디자인 패턴이다. 오브젝트의 상태를 공유할 수 있는데,
> 플라이웨이트에서는 이와 같은 상태 정보를 외부 자료구조에 저장하여 잠깐 사용할 수 있도록 전달한다.
 
### [Proxy(프록시)](src/structural/Proxy.java)

> 다른 무언가와 이어지는 인터페이스의 역할을 하는 방식이다. 객체를 직접 참조하는 것이 아니라 대생 객체에 연결할 수 있는 다른 객체를 통하여 대상 객체에 접근하는 방식을 사용하면,
> 해당 객체가 메모리에 없어도 기본적인 정보를 참조가 가능하면, 실제 객체에 기능이 필요한 시점 까지 객체의 생성을 미룰 수 있고, 접근 전 사전/사후 처리를 할 수 있다.  
> (데코레이터 패턴과 매우 유사하나, 두개의 차이점은 의도에 있다. 데코레이터 패턴은 기능을 추가하는것에 중점을 둔 반면에, 프록시는 세부적으로 정의 된 하우스키핑 코드를 원본으로부터 분리하는 역할을 한다.)

## 3. 행위 패턴(Behavioral Pattern)

### [Chain of Responsibility(책임 연쇄)](src/behavioral/ChainOfResponsibility.java)

> 명령과 처리를 포함하는 디자인 패턴이다. 각가의 처리 객체는 명령 객체를 처리할 수 있는 연산의 집합으로 표현할 수 있고, 체인 안에 처리 객체가 핸들할 수 없는 명령을 다음 처리 객체로 넘겨진다.
> 결합을 느슨하게 하기 위해 고안된 패턴이며 가장 좋은 프로그래밍 사례로도 꼽힌다. 또한 이 모델이 변화하며 다양한 방향으로 명령을 보내 책임을 트리 형태로 바꾸는 관제사 역할을 하기도 한다. (Servlet Filter!)

### [Commend(커맨드)](src/behavioral/Commend.java)

> 요청을 객체의 형태로 캡슐화하여 사용자가 보낸 요청을 나중에 이용할 수 있도록 이름, 매개변수 등 요청에 필요한 정보를 저장 또는 로깅, 취소할 수 있게 하는 패턴이다.
> 커맨드 패턴은 명령, 수신자, 발동자, 클라이언트 네개의 용어가 같이 따라온다. 커맨드 객체는 수신자 객체를 가지고 있고, 수신자의 메서드를 호출하고, 수신자는 자신에게 정의 된 메서드를 수행한다.
> (이러한 명령 객체를 통해서 자바에서는 지원하지 않는 일급 함수를 어느정도 따라할 수 있다.)

### [Interpreter(인터프리터)](src/behavioral/Interpreter.java)

> 간단한 문법을 정의하고 해선하는 패턴, 언어가 주어지면 해당 표현을 사용하여 언어로 문장을 해석하는 인터프리터를 사용하여 문법 표현을 정의하는 패턴
> 각 문법 규칙을 클래스로 표현하기 때문에 언어를 보다 쉽게 구현할 수 있고, 쉽게 확장하거나 변경할 수 있다. 하지만 문법의 개수가 많아지면 복잡해지고 다양한 문법이 생성되면 성능 저하가 발생한다.

### [Iterator(이터레이터)](src/behavioral/Iterator.java)

> 접근 기능과 자료구조를 분리시켜서 객체회 한다. 컬렉션의 구현 방법을 노출 시키지 않고도 그 집합체 안에 들어있는 모든 항목에 접근할 수 있는 방법을 제공하는 패턴이다. 모든 항목에 접근하는 작업을 컬렉션이 아니라 반복자 객체에서 맡게 된다.

### [Mediator(중재자)](src/behavioral/Mediator.java)

> 객체들의 집합이 어떻게 상호작용 하는지를 함축해놓은 객체를 정의하는 패턴이다. 객체 간 통신은 중재자 객체 안에 함축되고, 객체들은 다른 객체와 서로 통신하지 않으며, 대신 중재자를 통해 통신한다.
> 이를 통해 통신 객체간 의존성을 줄일 수 있으므로 결합도를 감소시킨다.

### [Memento(메멘토)](src/behavioral/Memento.java)

> 객체의 상태 정보를 가지는 클래스를 생성해서 객체의 상태를 저장하거나 이전의 상태로 복원할 수 있는 패턴이다.
> 원하는 상태의 시점으로 복구가 가능하다. 메멘토 패턴은 오리지네이터(originator), 케어테이커(caretaker), 메멘토(memento)로 이루어져 있다. 
> 오리지네이터는 내부 상태를 보유하고 있는 일부 객체이다. 케어테이커는 오리지네이터에 대해 무언가를 하지만 변경에 대한 실행 취소를 하기를 원한다. 케어테이커는 먼저 오리지네이터에게 메멘토 객체를 요청한다. 그 뒤 예정된 일련의 명령을 수행한다. 명령 이전의 상태로 되돌리기 위해 메멘토 객체를 오리지네이터에 반환한다.

### [Observer(옵서버)](src/behavioral/Observer.java)

> 객체의 상태를 관찰하고 있다가, 상태 변화가 있을 때 마다 메서드 등을 통하여서 각 옵저버들에게 통지하도록 하는 패턴이다.
> 주로 분산 이벤트 핸들링을 위해 사용된다. Pub/Sub 모델로 알려져 있다.
> 
### [State(상태)](src/behavioral/State.java)

> 객체지향 방식으로 상태 기계를 구현하는 방식의 패턴이다. 상태 패턴을 이용하면 상태 패턴 인터페이스의 파생 클래스로 각각의 상태를 구현하고, 또 패턴의 슈퍼클래스에 정의되어 있는 메서드를 호출하여 상태변화를 구현한다.