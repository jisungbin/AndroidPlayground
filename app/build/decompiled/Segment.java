package androidx.compose.foundation.demos.text;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {2, 2, 0},
   k = 1,
   xi = 48,
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"},
   d2 = {"Landroidx/compose/foundation/demos/text/Segment;", "", "leftPosition", "", "rightPosition", "leftOffset", "", "rightOffset", "<init>", "(FFII)V", "getLeftPosition", "()F", "getRightPosition", "getLeftOffset", "()I", "getRightOffset", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}
)
@StabilityInferred(
   parameters = 1
)
public final class Segment {
   private final float leftPosition;
   private final float rightPosition;
   private final int leftOffset;
   private final int rightOffset;
   public static final int $stable;

   public Segment(float leftPosition, float rightPosition, int leftOffset, int rightOffset) {
      this.leftPosition = leftPosition;
      this.rightPosition = rightPosition;
      this.leftOffset = leftOffset;
      this.rightOffset = rightOffset;
   }

   public final float getLeftPosition() {
      return this.leftPosition;
   }

   public final float getRightPosition() {
      return this.rightPosition;
   }

   public final int getLeftOffset() {
      return this.leftOffset;
   }

   public final int getRightOffset() {
      return this.rightOffset;
   }

   public final float component1() {
      return this.leftPosition;
   }

   public final float component2() {
      return this.rightPosition;
   }

   public final int component3() {
      return this.leftOffset;
   }

   public final int component4() {
      return this.rightOffset;
   }

   @NotNull
   public final Segment copy(float leftPosition, float rightPosition, int leftOffset, int rightOffset) {
      return new Segment(leftPosition, rightPosition, leftOffset, rightOffset);
   }

   // $FF: synthetic method
   public static Segment copy$default(Segment var0, float var1, float var2, int var3, int var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.leftPosition;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.rightPosition;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.leftOffset;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.rightOffset;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   @NotNull
   public String toString() {
      return "Segment(leftPosition=" + this.leftPosition + ", rightPosition=" + this.rightPosition + ", leftOffset=" + this.leftOffset + ", rightOffset=" + this.rightOffset + ")";
   }

   public int hashCode() {
      int result = Float.hashCode(this.leftPosition);
      result = result * 31 + Float.hashCode(this.rightPosition);
      result = result * 31 + Integer.hashCode(this.leftOffset);
      result = result * 31 + Integer.hashCode(this.rightOffset);
      return result;
   }

   public boolean equals(@Nullable Object other) {
      if (this == other) {
         return true;
      } else if (!(other instanceof Segment)) {
         return false;
      } else {
         Segment var2 = (Segment)other;
         if (Float.compare(this.leftPosition, var2.leftPosition) != 0) {
            return false;
         } else if (Float.compare(this.rightPosition, var2.rightPosition) != 0) {
            return false;
         } else if (this.leftOffset != var2.leftOffset) {
            return false;
         } else {
            return this.rightOffset == var2.rightOffset;
         }
      }
   }
}
