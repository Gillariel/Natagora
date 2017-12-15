<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\ObservationTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\ObservationTable Test Case
 */
class ObservationTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\ObservationTable
     */
    public $Observation;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.observation',
        'app.bird',
        'app.observation_bird'
    ];

    /**
     * setUp method
     *
     * @return void
     */
    public function setUp()
    {
        parent::setUp();
        $config = TableRegistry::exists('Observation') ? [] : ['className' => ObservationTable::class];
        $this->Observation = TableRegistry::get('Observation', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->Observation);

        parent::tearDown();
    }

    /**
     * Test initialize method
     *
     * @return void
     */
    public function testInitialize()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }

    /**
     * Test validationDefault method
     *
     * @return void
     */
    public function testValidationDefault()
    {
        $this->markTestIncomplete('Not implemented yet.');
    }
}
