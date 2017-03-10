package com.example.rxjavademo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "tag";
    private TextView tv1, tv2, tv3, tv4;
    private ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        iv1 = (ImageView) findViewById(R.id.iv1);
        //创建一个观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted:observer ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext:observer " + s);
            }
        };

        //Subscriber 是Observer的抽象类   对observer进行了扩容 但基本使用方法一样
        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                Log.i(TAG, "onCompleted:subscriber ");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "onNext:subscriber " + s);
            }
        };
        /**
         * 在 RxJava 的 subscribe 过程中，Observer 也总是会先被转换成一个 Subscriber 再使用。
         *只使用基本功能，选择 Observer 和 Subscriber 是完全一样的
         * 区别：
         * 1. onStart(): 这是 Subscriber 增加的方法。它会在 subscribe 刚开始，而事件还未发送之前被调用，
         * 可以用于做一些准备工作，例如数据的清零或重置。这是一个可选方法，默认情况下它的实现为空。需要注意的是，
         * 如果对准备工作的线程有要求（例如弹出一个显示进度的对话框，这必须在主线程执行），
         * onStart() 就不适用了，因为它总是在 subscribe 所发生的线程被调用，而不能指定线程。
         * 要在指定的线程来做准备工作，可以使用 doOnSubscribe() 方法，具体可以在后面的文中看到。
         * 2. unsubscribe(): 这是 Subscriber 所实现的另一个接口 Subscription 的方法，用于取消订阅。
         * 在这个方法被调用后，Subscriber 将不再接收事件。一般在这个方法调用前，
         * 可以使用 isUnsubscribed() 先判断一下状态。 unsubscribe() 这个方法很重要，因为在 subscribe() 之后，
         * Observable 会持有 Subscriber 的引用，这个引用如果不能及时被释放，将有内存泄露的风险。
         * 所以最好保持一个原则：要在不再使用的时候尽快在合适的地方（例如 onPause() onStop() 等方法中）
         * 调用 unsubscribe() 来解除引用关系，以避免内存泄露的发生。
         * */

        //创建被观察者 observable 它决定什么时候触发事件以及触发怎样的事件
        Observable observable0 = Observable.create(new Observable.OnSubscribe<String>() {
            /**
             * 可以看到，这里传入了一个 OnSubscribe 对象作为参数。OnSubscribe 会被存储在返回的 Observable 对象中，
             * 它的作用相当于一个计划表，当 Observable 被订阅的时候，OnSubscribe 的 call() 方法会自动被调用，
             * 事件序列就会依照设定依次触发（对于上面的代码，就是观察者Subscriber 将会被调用三次 onNext()
             * 和一次 onCompleted()）。这样，由被观察者调用了观察者的回调方法，
             * 就实现了由被观察者向观察者的事件传递，即观察者模式。
             * */
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1");
                subscriber.onNext("2");
                subscriber.onNext("3");
                subscriber.onCompleted();
            }
        });
        //Rxjava 还提供了其他快捷创建事件的方法
        Observable observable1 = Observable.just("1", "2", "3");

        final String[] str = {"1", "2", "3"};
        Observable observable2 = Observable.from(str);

        //Subscribe 订阅
        //在创建了observer  和 observable 后使用 subscribe()的方法将它们联合起来 整条链子就可以工作了
        observable0.subscribe(observer);
        //或者：
        observable0.subscribe(subscriber);
        /**
         * 有人可能会注意到， subscribe() 这个方法有点怪：
         * 它看起来是『observalbe 订阅了 observer / subscriber』而不是『observer / subscriber 订阅了 observalbe』，
         * 这看起来就像『杂志订阅了读者』一样颠倒了对象关系。这让人读起来有点别扭，
         * 不过如果把 API 设计成 observer.subscribe(observable) / subscriber.subscribe(observable) ，
         * 虽然更加符合思维逻辑，但对流式 API 的设计就造成影响了，比较起来明显是得不偿失的。
         * */
        /**
         * 除了 subscribe(Observer) 和 subscribe(Subscriber) ，
         * subscribe() 还支持不完整定义的回调，RxJava 会自动根据定义创建出 Subscriber 。形式如下：
         */
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(TAG, "call: Action1" + s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.i(TAG, "call: Action1" + throwable);
            }
        };
        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {
                Log.i(TAG, "call:onCompletedAction ");
            }
        };
        // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
        // 这个就相当于把观察者的 onNext方法改变成自己定义的 （我估计的）
        observable0.subscribe(onNextAction);
        // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
        observable0.subscribe(onNextAction, onErrorAction);
        // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        observable0.subscribe(onNextAction, onErrorAction, onCompletedAction);

        //线程控制  Scheduler（调度器）
        /**
         * Schedulers.immediate(): 直接在当前线程运行，相当于不指定线程。这是默认的 Scheduler。
         * Schedulers.newThread(): 总是启用新线程，并在新线程执行操作
         * Schedulers.io(): I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。
         *  Schedulers.io()和Schedulers.newThread()差不多，IO可以重用空闲的线程，不要把计算工作放到IO
         *
         *  Schedulers.computation(): 计算所使用的 Scheduler
         *  这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作
         *  例如图形的计算。这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。
         *  不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。
         *
         *  另外， Android 还有一个专用的 AndroidSchedulers.mainThread()，它指定的操作将在 Android 主线程运行。
         * */

        /**
         *可以使用 subscribeOn() 和 observeOn() 两个方法来对线程进行控制
         * subscribeOn(): 指定 subscribe() 所发生的线程，即 Observable.OnSubscribe 被激活时所处的线程,或者叫做事件产生的线程
         *  * observeOn(): 指定 Subscriber 所运行在的线程。或者叫做事件消费的线程
         * */
        Observable.just("1", "2", "3", "4")
                .subscribeOn(Schedulers.io())//subscribe()方法发生在 io线程中
                .observeOn(AndroidSchedulers.mainThread())//指定subscribe 回调在主线程中
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, "onNext: Observable" + s);
                        tv1.setText(s);
                    }
                });
        final int images = R.drawable.ic_launcher;
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {

                subscriber.onNext(images);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        iv1.setImageResource(integer.intValue());
                    }
                });
        //变换  （核心功能）
        //RxJava 提供了对事件序列进行变换的支持，这是它的核心功能之一
        //所谓变换，就是将事件序列中的对象或整个序列进行加工处理，转换成不同的事件或事件序列
        //.1
        /**
         * 这里出现了一个叫做 Func1 的类。它和 Action1 非常相似，也是 RxJava 的一个接口，用于包装含有一个参数的方法
         * Func1 和 Action 的区别在于， Func1 包装的是有返回值的方法
         * 和 ActionX 一样， FuncX 也有多个，用于不同参数个数的方法
         * FuncX 和 ActionX 的区别在 FuncX 包装的是有返回值的方法
         *
         *
         * map() 方法将参数中的 String 对象转换成一个 Bitmap 对象后返回
         * 而在经过 map() 方法后，事件的参数类型也由 String 转为了 Bitmap
         *不仅可以针对事件对象，还可以针对整个事件队列
         * map（）是一对一
         * */
        Observable.just("images/logo.png")
                .map(new Func1<String, Bitmap>() {

                    @Override
                    public Bitmap call(String s) {
                        return BitmapFactory.decodeFile(s);
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bitmap>() {
                    @Override
                    public void call(Bitmap bitmap) {
                        iv1.setImageBitmap(bitmap);
                    }
                });
        Observable.just("abcde")
                .map(new Func1<String, Integer>() {

                    @Override
                    public Integer call(String s) {
                        return s.hashCode();
                    }
                })
                .map(new Func1<Integer, String>() {

                    @Override
                    public String call(Integer integer) {
                        return integer+"";
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                    }

                    @Override
                    public void onCompleted() {
                        Log.i(TAG, "onCompleted: 完成了");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: 出错了 ");
                    }

                    @Override
                    public void onNext(String s) {
                        tv2.setText(s);
                    }
                });

        /**
         * flatMap()( 这是一个很有用但非常难理解的变换)
         *flatMap 是一对多进变换
         * */
        //测试1  有一个对象 student  其中有一个属性name
//        List<Student> data=new ArrayList<>();
//        Student student1=new Student("name1");
//        Student student2=new Student("name2");
//        Student student3=new Student("name3");
//        Student student4=new Student("name4");
//        Student student5=new Student("name5");
//        data.add(student1);
//        data.add(student2);
//        data.add(student3);
//        data.add(student4);
//        data.add(student5);
//        //现在要打印学生的名字
//        Subscriber<String> subscriber1=new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                Log.i(TAG, "onCompleted: 完成了");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.i(TAG, "onNext: 学生="+s);
//            }
//        };
//        Observable.from(data)
//                .map(new Func1<Student,String>() {
//                    @Override
//                    public String call(Student student) {
//                        return student.getName();
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber1);

        //测试2   假设每个学生都有很多们课程
        List<Student> data=new ArrayList<>();
        Student student1=new Student("name1");
        Student student2=new Student("name2");
        List<Courses> cours=new ArrayList<>();
        Courses courses1=new Courses("course1");
        Courses courses2=new Courses("course2");
        Courses courses3=new Courses("course3");
        Courses courses4=new Courses("course4");
        Courses courses5=new Courses("course5");
        cours.add(courses1);
        cours.add(courses2);
        cours.add(courses3);
        cours.add(courses4);
        cours.add(courses5);
        student1.setCourses(cours);
        student2.setCourses(cours);
        data.add(student1);
        data.add(student2);
//        Subscriber<Student> subscriber1=new Subscriber<Student>() {
//            @Override
//            public void onCompleted() {
//                Log.i(TAG, "onCompleted: 测试2");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Student s) {
//                for (int i = 0; i < s.getCourses().size(); i++) {
//                    Log.i(TAG, "onNext: 测试2="+s.getCourses().get(i));
//                }
//            }
//        };
//
//        Observable.from(data)
//           .subscribe(subscriber1);
            //测试3  使用flatmap进行变换
        // 个人理解： 首先 observable  从data中取第一个Student的对象 然后 在call方法中 返回一个observable
        //            这个observable中携带 一个Courses集合    然后根据from 进行事件的消费 当第一个Courses集合的数据消费
        //            完成后   第一个observable 开始取第二个Student的对象  个人感觉相当于2维数组的遍历
            Observable.from(data)
                    .flatMap(new Func1<Student, Observable<Courses>>() {
                        @Override
                        public Observable<Courses> call(Student student) {
                            //返回了一个被观察者
                            return Observable.from(student.getCourses());
                        }
                    })
                    .take(3)//输出最多指定的数量
                    .doOnNext(new Action1<Courses>() {
                        @Override
                        public void call(Courses courses) {
                            Log.i(TAG, "call: abcd");//在每次 订阅者执行前 做的事情 例如保存数据
                        }
                    })
                    .subscribe(new Subscriber<Courses>() {
                        @Override
                        public void onStart() {
                            super.onStart();
                            unsubscribe();//
                        }

                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(Courses courses) {
                            Log.i(TAG, "onNext: 测试3="+courses.getName());
                        }
                    });





    }


}
