<?php
namespace App\Test\TestCase\Model\Table;

use App\Model\Table\BirdTable;
use Cake\ORM\TableRegistry;
use Cake\TestSuite\TestCase;

/**
 * App\Model\Table\BirdTable Test Case
 */
class BirdTableTest extends TestCase
{

    /**
     * Test subject
     *
     * @var \App\Model\Table\BirdTable
     */
    public $Bird;

    /**
     * Fixtures
     *
     * @var array
     */
    public $fixtures = [
        'app.bird',
        'app.observation',
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
        $config = TableRegistry::exists('Bird') ? [] : ['className' => BirdTable::class];
        $this->Bird = TableRegistry::get('Bird', $config);
    }

    /**
     * tearDown method
     *
     * @return void
     */
    public function tearDown()
    {
        unset($this->Bird);

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
