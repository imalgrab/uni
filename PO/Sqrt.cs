using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calculator
{
    class Sqrt : UnaryOperation
    {
        public double value;

        public Sqrt(double value)
        {
            this.value = value;
        }

        public override double Evaluate()
        {
            return Math.Sqrt(value);
        }

        public override string Result()
        {
            return $"sqrt({value})";
        }
    }
}
