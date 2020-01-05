//package com.kafka.stream.processor;
//
//import java.time.Duration;
//
//import org.apache.kafka.streams.KeyValue;
//import org.apache.kafka.streams.kstream.Transformer;
//import org.apache.kafka.streams.kstream.TransformerSupplier;
//import org.springframework.boot.test.util.TestPropertyValues.Pair;
//
//
//public class StreamTableJoinStreamSideLogic implements TransformerSupplier<String, Double, KeyValue<String, Pair<Double, Long>>> {
//
//  // private static final Log LOG = LoggerFactory.getLogger(StreamTableJoinStreamSideLogic.class);
//
//   private final Duration joinWindow;
//   private final String tableStoreName;
//
////   StreamTableJoinStreamSideLogic(final Duration joinWindow, final String tableStoreName) {
////     this.joinWindow = joinWindow;
////     this.tableStoreName = tableStoreName;
////   }
//
//   @Override
//   public Transformer<String, Double, KeyValue<String, Pair<Double, Long>>> get() {
//     return new Transformer<String, Double, KeyValue<String, Pair<Double, Long>>>() {
//
//       private KeyValueStore<String, ValueAndTimestamp<Long>> tableStore;
//       private ProcessorContext context;
//
//       @SuppressWarnings("unchecked")
//       @Override
//       public void init(final ProcessorContext context) {
//         tableStore = (KeyValueStore<String, ValueAndTimestamp<Long>>) context.getStateStore(tableStoreName);
//         this.context = context;
//       }
//
//       @Override
//       public KeyValue<String, Pair<Double, Long>> transform(final String key, final Double value) {
//         LOG.info("Received stream record ({}, {}) with timestamp {}", key, value, context.timestamp());
//         return sendFullJoinRecordOrWaitForTableSide(key, value, context.timestamp());
//       }
//
//}
//   }
//}
